#!/usr/bin/env python

import socket
import serial


if __name__ == '__main__':
    TCP_IP = '127.0.0.1'#'192.168.1.20'
    TCP_PORT = 5005
    BUFFER_SIZE = 20  # Normally 1024, but we want fast response

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((TCP_IP, TCP_PORT))
    s.listen(1)

    conn, addr = s.accept()
    print 'Connection address:', addr
    ser = serial.Serial('/dev/ttyACM0',115200,timeout=0.010)
    while 1:
        send_msg = ser.read()
        #data = conn.recv(BUFFER_SIZE)
        #if not data: break
        #ser.write(data)
        #print "Received data: ", send_msg#data
        conn.send(send_msg)
        if send_msg:
            print "Sent data: ", send_msg
    conn.close()
    ser.close()
