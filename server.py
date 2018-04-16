#!/usr/bin/python
import serial
import socket
import sys
import time
import logging
import os

print("SERVER RUNNING")

if __name__ == "__main__":
	PORT = 2000
	IPADDR = "192.168.1.66" #IP ADDR
	size = 6
	filename = 'CERBERUS.log'
	switch_file = 0

	# check log file size if exists
	if os.path.isfile(filename):
		statinfo = os.stat('CERBERUS.log')
		print(statinfo.st_size)
		# if the log file becomes bigger than 2GB 
		if statinfo.st_size >= 2000000000:
			switch_file = 1
			filename = 'CERBERUS_extra.log'

	# setup logger
	logger = logging.getLogger('log')
	logging.basicConfig(filename=filename, format='%(asctime)s %(name)-12s %(levelname)-8s %(message)s', level=logging.DEBUG)
	logger.debug('Logger started successfully')

	# connect to serial port
	ser = serial.serial_for_url('/dev/ttyUSB0', do_not_open=True)
	ser.baudrate = 115200

	try:
		ser.open()
	except serial.SerialException as e:
		logger.debug('Could not open serial port {}: {}'.format(ser.name, e))
		sys.exit(1)

	server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	server_socket.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
	server_socket.bind((IPADDR, PORT))
	server_socket.listen(1)

	while 1:
		client, address = server_socket.accept()
#		client.setblocking(0)
		client.settimeout(0.05)
		logger.debug('WAITNG TO ESTABLISH CLIENT...')
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
				logger.debug('DATA->CLIENT' + x)
				if switch_file == 1:
					client.send(b'\x02')
			# occurs when client disconnects
			except socket.error:
				client.close()
				logger.debug('CLIENT DISCONNECTED')
				break
	client.send(b'\x00')
	logger.debug('SERVER STOPPED')
	server_socket.close()
