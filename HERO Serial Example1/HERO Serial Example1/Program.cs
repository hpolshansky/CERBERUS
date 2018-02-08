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
        /** Serial object, this is constructed on the serial number. */
        static System.IO.Ports.SerialPort _uart;
        /** Ring buffer holding the bytes to transmit. */
        static byte[] _tx = new byte[1024];
        static int _txIn = 0;
        static int _txOut = 0;
        static int _txCnt = 0;
        /** Cache for reading out bytes in serial driver. */
        static byte[] _rx = new byte[1024];
        /* initial message to send to the terminal */
        static byte[] _helloMsg = MakeByteArrayFromString("HERO_Serial_Example1 - Start Typing and HERO will echo the letters back.\r\n");
        /** @return the maximum number of bytes we can read*/
        private static int CalcRemainingCap()
        {
            /* firs calc the remaining capacity in the ring buffer */
            int rem = _tx.Length - _txCnt;
            /* cap the return to the maximum capacity of the rx array */
            if (rem > _rx.Length)
                rem = _rx.Length;
            return rem;
        }
        /** @param received byte to push into ring buffer */
        private static void PushByte(byte datum)
        {
            _tx[_txIn] = datum;
            if (++_txIn >= _tx.Length)
                _txIn = 0;
            ++_txCnt;
        }
        /** 
         * Pop the oldest byte out of the ring buffer.
         * Caller must ensure there is at least one byte to pop out by checking _txCnt.
         * @return the oldest byte in buffer.
         */
        private static byte PopByte()
        {
            byte retval = _tx[_txOut];
            if (++_txOut >= _tx.Length)
                _txOut = 0;
            --_txCnt;
            return retval;
        }

        //public static decimal Map(this decimal value, decimal fromSource, decimal toSource, decimal fromTarget, decimal toTarget)
        //{
        //    return (value - fromSource) / (toSource - fromSource) * (toTarget - fromTarget) + fromTarget;
        //}

        /** entry point of the application */
        public static void Main()
        {
            //CTRE.Phoenix.MotorControllers.TalonSrx talonID0 = new CTRE.Phoenix.MotorControllers.TalonSrx(0);
            //CTRE.Phoenix.MotorControllers.TalonSrx talonID1 = new CTRE.Phoenix.MotorControllers.TalonSrx(1);

            /* temporary array */
            //byte[] scratch = new byte[1];
            byte[] buf = new byte[4]; //Frame size
            uint indOffset = 3;
            /* open the UART, select the com port based on the desired gadgeteer port.
             *   This utilizes the CTRE.IO Library.
             *   The full listing of COM ports on HERO can be viewed in CTRE.IO
             */
            _uart = new System.IO.Ports.SerialPort(CTRE.HERO.IO.Port1.UART, 115200);
            _uart.Open();
            /* send a message to the terminal for the user to see */
            //_uart.Write(_helloMsg, 0, _helloMsg.Length);
            /* loop forever */
            while (true)
            {

                //talonID0.SetInverted(true);
                //talonID1.SetInverted(true);

                
                //// motors at 20% speed
                //// talonID0.Set(# value from -1 to 1);
                //talonID0.Set(gamepad.GetAxis(1));
                //talonID1.Set(gamepad.GetAxis(3));


                /* read bytes out of uart */
                if (_uart.BytesToRead > 0)
                {
                    int readCnt = _uart.Read(_rx, 0, CalcRemainingCap());
                    for (int i = 0; i < readCnt; ++i)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            buf[j] = buf[j + 1];
                        }
                        buf[3] = _rx[i];
                        //Debug.Print((buf[0]).ToString());
                        if ((buf[0] & (1 << 7)) != 0x00)
                        {
                            //SOF detected
                            byte Lupper = (byte)(0x7F & buf[0]);
                            byte Llower = (byte)(0x7F & buf[1]);
                            byte data_2 = (byte)((Lupper << 1) | ((Llower | 0x40) >> 6));
                            byte data_3 = (byte)((Llower & 0x3F) << 2);
                            UInt16 leftVal = (ushort)((data_2 << 8) | (data_3));
                            UInt16 rightVal = (ushort)((buf[2] << 9) | (buf[3]) << 2);
                            //32764 - (2^16 - 4)
                            float leftTalon = (leftVal-49150)/16386.0f;// ((-(float)2 / 32767) * leftVal) + 1;
                            float rightTalon = rightVal;// ((-(float)2 / 65535) * rightVal) + 1;

                            Debug.Print("LEFT: " + leftTalon.ToString());
                            Debug.Print("RIGHT: " + rightTalon.ToString());

                        }
                        //PushByte(_rx[i]);
                    }
                }
                /* if there are bufferd bytes echo them back out */
                if (_uart.CanWrite && (_txCnt > 0))
                {
                 

                    //_uart.Write(scratch, 0, 1);
                }
                /* wait a bit, keep the main loop time constant, this way you can add to this example (motor control for example). */
                Thread.Sleep(10);
            }
        }
        /**
         * Helper routine for creating byte arrays from strings.
         * @param msg string message to covnert.
         * @return byte array version of string.
         */
        private static byte[] MakeByteArrayFromString(String msg)
        {
            byte[] retval = new byte[msg.Length];
            for (int i = 0; i < msg.Length; ++i)
                retval[i] = (byte)msg[i];
            return retval;
        }
    }
}
