#!/usr/bin/python
import serial
import socket
import sys
import time
import logging

print("SERVER RUNNING")

if __name__ == "__main__":
	PORT = 2000
	IPADDR = "192.168.1.66" #IP ADDR
	size = 6
	c = 0

	# setup logger
	logger = logging.getLogger('log')
	logging.basicConfig(filename='CERBERUS.log', format='%(asctime)s %(name)-12s %(levelname)-8s %(message)s', level=logging.DEBUG)
	handler = logging.StreamHandler()
	formatter = logging.Formatter('%(asctime)s %(name)-12s %(levelname)-8s %(message)s')
	handler.setFormatter(formatter)
	logger.addHandler(handler)
#	logger.setLevel(logging.DEBUG)

	logger.debug('Logger started successfully')

	# connect to serial port
	ser = serial.serial_for_url('/dev/ttyUSB0', do_not_open=True)
	ser.baudrate = 115200

	try:
		ser.open()
	except serial.SerialException as e:
		sys.stderr.write('Could not open serial port {}: {}\n'.format(ser.name, e))
		sys.exit(1)

	server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	server_socket.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
	server_socket.bind((IPADDR, PORT))
	server_socket.listen(1)

	while 1:
		client, address = server_socket.accept()
#		client.setblocking(0)
		client.settimeout(0.05)
		while 1:
			try:
				data = client.recv(size)
				if data != None:
					ser.write(data)
			# occurs when client is not sending data yet
			except socket.error:
				pass

			try:
				x = ser.read(3)
				client.send(x)
			# occurs when client disconnects
			except socket.error:
				client.close()
				break
	x = b'\x00'
	client.send(x)
	server_socket.close()
