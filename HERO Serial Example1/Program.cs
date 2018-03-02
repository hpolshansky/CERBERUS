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
        static float leftOut = 0;
        static float rightOut = 0;
        /** Serial object, this is constructed on the serial number. */
        static System.IO.Ports.SerialPort _uart;
        /** Ring buffer holding the bytes to transmit. */
        //static byte[] _tx = new byte[1024];
        // EXTRA
        //static byte[] _tx = new byte[8];
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
                else
                {
                        data[ind - 1] = frame[ind];
                }
            }
            return data;
        }
        /** entry point of the application */
        public static void Main()
        {
            CTRE.Phoenix.MotorControllers.TalonSrx talonID0 = new CTRE.Phoenix.MotorControllers.TalonSrx(0);
            CTRE.Phoenix.MotorControllers.TalonSrx talonID1 = new CTRE.Phoenix.MotorControllers.TalonSrx(1);

            
            _uart = new System.IO.Ports.SerialPort(CTRE.HERO.IO.Port1.UART, 115200);
            _uart.Open();
            ushort rx_len = 6;
            byte[] loc_rx_buf = new byte[rx_len];
            for(int k = 0; k<rx_len;k++)
            {
                loc_rx_buf[k] = 0x01;
            }
            while (true)
            {

                talonID0.SetInverted(true);
                talonID1.SetInverted(true); // Why is this in a loop?

                /* read bytes out of uart */
                if (_uart.BytesToRead > 0)
                {
                    byte[] readByte = { 0x00 };
                    _uart.Read(readByte,0,1);
                    byte nextByte = readByte[0];
                    //nextByte = (byte)(nextByte-1);
                    //nextByte = (byte)~nextByte;
                    //Debug.Print(nextByte.ToString());
                    for (int j = 0; j < rx_len - 1; j++)
                    {
                        loc_rx_buf[j] = loc_rx_buf[j + 1];
                    }
                    loc_rx_buf[rx_len - 1] = nextByte;
                    //Debug.Print(nextByte.ToString());
                    //Check if in place
                    if ((loc_rx_buf[rx_len - 1] == 0x00)) //TODO: Make so isn't frame size specific
                    {

                        byte[] msgDec = Decode(loc_rx_buf);
                        short left = BitConverter.ToInt16(msgDec, 0);//(ushort)((msgDec[0]<<8) | msgDec[1]);
                        short right = BitConverter.ToInt16(msgDec, 2);
                        //Debug.Print(left.ToString());
                        //Debug.Print(right.ToString());
                        //talonID0.Set(rightTalon);
                        //talonID1.Set(leftTalon);
                        float leftFloat = ((-0.00003f) * left) - 0.0013f;
                        float rightFloat = ((-0.00003f) * right) - 0.0013f;
                        if((leftFloat<0.15) && (leftFloat > -0.15))
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
                Debug.Print("left: " + leftOut.ToString());
                Debug.Print("right: " + rightOut.ToString());

                //talonID0.Set(Program.rightOut);
                //talonID1.Set(Program.leftOut);
                CTRE.Phoenix.Watchdog.Feed();

                /* wait a bit, keep the main loop time constant, this way you can add to this example (motor control for example). */
                Thread.Sleep(10);
            }
        }
    }
}
