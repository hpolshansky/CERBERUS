#!/usr/bin/env python

import socket

if __name__ == '__main__':
    TCP_IP = '127.0.0.1'
    TCP_PORT = 5005
    BUFFER_SIZE = 20

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((TCP_IP, TCP_PORT))

    ser = serial.Serial('/dev/ttyACM0')
    ser.baudrate = 115200
    ser.timeout = 0
    ser.open()  
    
    while(1):
        msg = ser.read()
        s.send(msg)
        data = s.recv(BUFFER_SIZE)
        ser.write(data);
        print "Received data: ", data
        print "Sent data: ", msg
    s.close()
    ser.close()


