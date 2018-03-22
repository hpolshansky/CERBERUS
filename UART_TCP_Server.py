#!/usr/bin/env python

import socket
import serial
import fcntl, os

if __name__ == '__main__':
    TCP_IP = '127.0.0.1'#'192.168.1.20'
    TCP_PORT = 5005
    BUFFER_SIZE = 20

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((TCP_IP, TCP_PORT))
    s.listen(1)

    #fcntl.fcntl(s, fcntl.F_SETFL, os.O_NONBLOCK)

    conn, addr = s.accept()
    print 'Connection address:', addr
    ser = serial.Serial('/dev/ttyACM0',115200,timeout=0.10)
    s.settimeout(.1)
    while 1:
        send_msg = ser.read()
        #data = conn.recv(BUFFER_SIZE)
        try:
            data = s.recv(BUFFER_SIZE)
        except socket.timeout, e:
            data = 0
            #print 'recv timed out, retry later'
        except socket.error, e:
            # Something else happened, handle error, exit, etc.
            print e
            sys.exit(1)
        #if not data: break
        if data:
            ser.write(data)
            print "Received data: ", data
        if send_msg:
            print "Sent data: ", send_msg
            conn.send(send_msg)
    conn.close()
    ser.close()
