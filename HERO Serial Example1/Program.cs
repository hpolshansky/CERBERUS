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
        //static byte[] _tx = new byte[1024];
        // EXTRA
        //static byte[] _tx = new byte[8];
        static byte[] _tx = new byte[4];

        static int _txIn = 0;
        static int _txOut = 0;
        static int _txCnt = 0;
        /** Cache for reading out bytes in serial driver. */
        //static byte[] _rx = new byte[1024];
        // EXTRA
        //static byte[] _rx = new byte[8];
        static byte[] _rx = new byte[4];
        /* initial message to send to the terminal */
        //static byte[] _helloMsg = MakeByteArrayFromString("HERO_Serial_Example1 - Start Typing and HERO will echo the letters back.\r\n");

        /** @return the maximum number of bytes we can read*/
        private static int CalcRemainingCap()
        {
            /* first calc the remaining capacity in the ring buffer */
            int rem = _tx.Length - _txCnt;
            /* cap the return to the maximum capacity of the rx array */
            if (rem > _rx.Length)
                rem = _rx.Length;
            //Debug.Print("REMAINING: "+rem.ToString());
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

        /** entry point of the application */
        public static void Main()
        {
            CTRE.Phoenix.MotorControllers.TalonSrx talonID0 = new CTRE.Phoenix.MotorControllers.TalonSrx(0);
            CTRE.Phoenix.MotorControllers.TalonSrx talonID1 = new CTRE.Phoenix.MotorControllers.TalonSrx(1);

            /* temporary array */
            //byte[] scratch = new byte[1];
            //const int BUFLEN = 4;
            //byte[] buf = new byte[BUFLEN]; //Frame size

            //uint indOffset = BUFLEN-1;
            /* open the UART, select the com port based on the desired gadgeteer port.
             *   This utilizes the CTRE.IO Library.
             *   The full listing of COM ports on HERO can be viewed in CTRE.IO
             */
            _uart = new System.IO.Ports.SerialPort(CTRE.HERO.IO.Port1.UART, 115200);
            _uart.Open();
            /* send a message to the terminal for the user to see */
            //_uart.Write(_helloMsg, 0, _helloMsg.Length);
            /* loop forever */

            float leftTalon = 0;
            float rightTalon = 0;
            Boolean b_pressed = false;
            while (true)
            {

                talonID0.SetInverted(true);
                talonID1.SetInverted(true); // Why is this in a loop?

                /* read bytes out of uart */
                if (_uart.BytesToRead > 0)
                {
                    int readCnt = _uart.Read(_rx, 0, CalcRemainingCap());

                    Debug.Print("START 1: " + _rx[0].ToString());
                    Debug.Print(_rx[1].ToString());
                    Debug.Print(_rx[2].ToString());
                    Debug.Print("END: " + _rx[3].ToString());
                    //int l = _rx[0] + _rx[1] + _rx[2] + _rx[3];
                    //Debug.Print("LEFT DEC+: " + l.ToString());

                    //int leftVal = _rx[0] + _rx[1] + _rx[2] + _rx[3];
                    //int rightVal = _rx[4] + _rx[5] + _rx[6] + _rx[7];
                    // EXTRA
                    //int b = _rx[8] + _rx[9];

                    //Debug.Print("B: " + b.ToString());

                    //Debug.Print("VAL: " + leftVal.ToString());


                    //leftTalon = Map(leftVal, 192, 280);
                    //rightTalon = Map(rightVal, 192, 280);


                    // EXTRA for when button b is pressed, change speed
                    //if (b == 98 && b_pressed)
                    //{
                    //    // set motors back to half speed
                    //    Debug.Print("HALF");
                    //    leftTalon = Map(leftVal, 192, 280) / 2;
                    //    rightTalon = Map(rightVal, 192, 280) / 2;
                    //    b_pressed = false;
                    //}
                    //else if (b == 98 || b_pressed)
                    //{
                    //    // set motors full speed
                    //    Debug.Print("FULL");
                    //    //leftTalon = leftTalon*2;
                    //    //rightTalon = rightTalon*2;
                    //    leftTalon = Map(leftVal, 192, 280);
                    //    rightTalon = Map(rightVal, 192, 280);
                    //    b_pressed = true;
                    //}
                    //else
                    //{
                    //    Debug.Print("ELSE");
                    //    leftTalon = Map(leftVal, 192, 280) / 2;
                    //    rightTalon = Map(rightVal, 192, 280) / 2;
                    //}
                }
                //for (int i = 0; i < readCnt; ++i)
                //{
                //    PushByte(_rx[i]);

                //for (int j = 0; j < BUFLEN-1; j++)
                //{
                //    buf[j] = buf[j + 1];
                //}
                //buf[BUFLEN-1] = _rx[i];

                //Debug.Print(BitConverter.ToString(buf));
                //Debug.Print("B1: " + (buf[1]).ToString());
                //Debug.Print("B2: " + (buf[2]).ToString());
                //Debug.Print("B3: " + (buf[3]).ToString());

                //if ((buf[0] & (1 << 7)) != 0x00)
                //{
                //SOF detected
                //byte Lupper = (byte)(0x7F & buf[0]);
                //byte Llower = (byte)(0x7F & buf[1]);
                //byte Rupper = (byte)(0x7F & buf[2]);
                //byte Rlower = (byte)(0x7F & buf[3]);
                //byte data_2 = (byte)((Lupper << 1) | ((Llower | 0x40) >> 6));
                //byte data_3 = (byte)((Llower & 0x3F) << 2);
                //byte data_6 = (byte)((Rupper << 1) | ((Rlower | 0x40) >> 6));
                //byte data_7 = (byte)((Rlower & 0x3F) << 2);
                //UInt16 leftVal = (ushort)((data_2 << 8) | (data_3));
                //UInt16 rightVal = (ushort)((data_6 << 8) | (data_7));

                //CheckVals(UInt16 val, UInt16 checkMin, UInt16 checkMax);
                
                // map vals

                //leftTalon = map(leftVal, 256, 57340);
                //rightTalon = map(rightVal, 256, 57340);

                //}
                //}
                //}



                //Debug.Print("LEFT: " + leftTalon.ToString());
                //Debug.Print("RIGHT: " + rightTalon.ToString());

                //talonID0.Set(rightTalon);
                //talonID1.Set(leftTalon);

                CTRE.Phoenix.Watchdog.Feed();

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

        // equation from: https://stackoverflow.com/questions/5731863/mapping-a-numeric-range-onto-another 
        private static float Map(int input, int input_start, int input_end)
        {
            float output = -(-1 + (2.0f / (input_end - input_start)) * (input - input_start));
            return output;
        }

        // checks the min and max values for the controller
        private static void CheckVals(UInt16 val, UInt16 checkMin, UInt16 checkMax)
        {
            if (checkMin > val)
            {
                checkMin = val;
                Debug.Print("MIN: " + checkMin.ToString());
            }
            if (checkMax < val)
            {
                checkMax = val;
                Debug.Print("MAX: " + checkMax.ToString());
            }
        }
    
    }
}
