/**
 * Example HERO application can reads a serial port and echos the bytes back.
 * After deploying this application, the user can open a serial terminal and type while the HERO echoes the typed keys back.
 * Use a USB to UART (TTL) cable like the Adafruit Raspberry PI or FTDI-TTL cable.
 * Use device manager to figure out which serial port number to select in your PC terminal program.
 * HERO Gadgeteer Port 1 is used in this example, but can be changed at the top of Main().
 *
 * IMPORTANT: This example requires the version of the SDK from the
 * Installer version 5.0.0.0 or higher.  There were several changes
 * and additions to multiple files in the SDK, and these are required
 * for this example
 * 
 */
using System;
using System.Threading;
using Microsoft.SPOT;

namespace CTRE_Serial_Example
{
    public class Program
    {
        static System.IO.Ports.SerialPort _uart;
        static float leftOut = 0;
        static float rightOut = 0;
        /* initial message to send to the terminal */
        //static byte[] _helloMsg = MakeByteArrayFromString("HERO_Serial_Example2 - Start Typing and HERO will echo the letters back.\r\n");
        /** Ring buffer holding the bytes to transmit. */
        //static byte[] _tx = new byte[1024];
        static byte[] Decode(byte[] frame)
        {
            ushort len = 6;
            //Assumes the zero end of packet is included
            //TODO: Add check for valid frame
            byte[] data = new byte[len - 2];
            byte count = frame[0];
            int ind = 0; //Start right after overhead
            while (count > 0)
            {
                ind++;
                count--;
                if (count == 0)
                {
                    if (frame[ind] != 0x00)
                    {
                        //Not Done. Replace with zero
                        count = frame[ind];
                        data[ind - 1] = 0x00;
                    }
                }
                else if ((count+ind) >= len)
                {
                    data[0] = 127;
                    data[1] = 255;
                    data[2] = 127;
                    data[3] = 255;
                    return data;
                }
                else
                {
                    if(frame[ind] == 0x00)
                    {
                        //127, -1, 127, -1
                        data[0] = 127;
                        data[1] = 255;
                        data[2] = 127;
                        data[3] = 255;
                        return data;
                    }
                    try
                    {
                        data[ind - 1] = frame[ind];
                    }
                    catch(IndexOutOfRangeException err)
                    {
                        return new byte[1];
                    }
                }
            }
            return data;
        }
        /** entry point of the application */
        public static void Main()
        {
            CTRE.Phoenix.MotorControllers.TalonSrx talonID0 = new CTRE.Phoenix.MotorControllers.TalonSrx(0);
            CTRE.Phoenix.MotorControllers.TalonSrx talonID1 = new CTRE.Phoenix.MotorControllers.TalonSrx(1);

            talonID0.SetInverted(true);
            talonID1.SetInverted(true);

            Boolean newMsg = false;
            float threshold = 0.10f;
            byte[] scratch = new byte[1];

            _uart = new System.IO.Ports.SerialPort(CTRE.HERO.IO.Port1.UART, 115200);
            _uart.Open();
            /* send a message to the terminal for the user to see */
            //_uart.Write(_helloMsg, 0, _helloMsg.Length);

            ushort rx_len = 6;
            byte[] loc_rx_buf = new byte[rx_len];
            for(int k = 0; k<rx_len;k++)
            {
                loc_rx_buf[k] = 0x01;
            }
            while (true)
            {
                /* read bytes out of uart */
                if (_uart.BytesToRead > 0)
                {
                    byte[] readByte = { 0x00 };
                    _uart.Read(readByte,0,1);
                    byte nextByte = readByte[0];

                    for (int j = 0; j < rx_len - 1; j++)
                    {
                        loc_rx_buf[j] = loc_rx_buf[j + 1];
                    }
                    loc_rx_buf[rx_len - 1] = nextByte;

                    if ((loc_rx_buf[rx_len - 1] == 0x00)) //TODO: Make so isn't frame size specific
                    {
                        byte[] msgDec = Decode(loc_rx_buf);
                        if (msgDec.Length == 4)
                        {
                            newMsg = true;
                            short left = BitConverter.ToInt16(msgDec, 0);
                            short right = BitConverter.ToInt16(msgDec, 2);
                            float leftFloat = ((-0.00003f) * left) - 0.0013f;
                            float rightFloat = ((-0.00003f) * right) - 0.0013f;
                            if ((leftFloat < 0.15) && (leftFloat > -0.15))
                            {
                                leftOut = 0.00f;
                            }
                            else
                            {
                                leftOut = leftFloat;
                            }
                            if ((rightFloat < 0.15) && (rightFloat > -0.15))
                            {
                                rightOut = 0.00f;
                            }
                            else
                            {
                                rightOut = rightFloat;
                            }
                        }
                    }

                }
                /* writes to uart */
                if (_uart.CanWrite /*&& _uart.BytesToWrite > 0*/)
                {
                    // send voltages of talons via CAN to client
                    // GetBusVoltage -> returns float
                    float talonRightVoltage = talonID0.GetBusVoltage();
                    //talonID1.GetBusVoltage();
                    //float f = 12.4f; // works
                    scratch[0] = (byte)((UInt16)talonRightVoltage & 0xFF); // works

                    Debug.Print("Bytes[0]: " + scratch[0].ToString()); //works                    
                    //_uart.Write(bytes, 0, 1);
                }

                // Thresholds the motor values
                if (newMsg)
                {
                    if (leftOut < threshold && leftOut > -threshold)
                    {
                        //Debug.Print("More left");
                        talonID1.Set(0.0f);
                    }
                    else
                    {
                        talonID1.Set(leftOut);
                    }
                    if (rightOut < threshold && rightOut > -threshold)
                    {
                        //Debug.Print("More right");
                        talonID0.Set(0.0f);
                    }
                    else
                    {
                        talonID0.Set(rightOut);
                    }
                    newMsg = false;
                }
                //Debug.Print("left: " + leftOut.ToString());
                //Debug.Print("right: " + rightOut.ToString());
                //talonID0.Set(0.0f);
                //talonID1.Set(0.0f);
                CTRE.Phoenix.Watchdog.Feed();

                /* wait a bit, keep the main loop time constant, this way you can add to this example (motor control for example). */
                Thread.Sleep(5);
            }
        }
    }
}
