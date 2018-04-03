#!/usr/bin/python
import serial
import socket
import sys
import time

print("TEST RUN")

if __name__ == "__main__":
	PORT = 2000
	IPADDR = "192.168.1.66" #IP ADDR
	size = 6

	# connect to serial port
	ser = serial.serial_for_url('/dev/ttyUSB0', do_not_open=True)
	ser.baudrate = 115200
	ser.timeout = 0.05
#	ser.write_timeout = 0.05

	try:
		ser.open()
	except serial.SerialException as e:
		sys.stderr.write('Could not open serial port {}: {}\n'.format(ser.name, e))
		sys.exit(1)

	server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	# server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
	server_socket.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
#	server_socket.settimeout(0.05);
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
#                	                print("here")
					try:
						ser.write(data)
					except serial.SerialTimeoutException:
						print("write timeout")
			except socket.error:
				# no data yet
#				print("no data")
#			if data != None:
#				print("here")
#				ser.write(data)
#				data = None
				try:
#			else:
					x = ser.read()
					client.send(x)
				except serial.SerialTimeoutException:
					print("read timeout")
#				log.exception("read timeout")
			
#			try:
			# write data
#			except SerialTimeoutException:
#				print("write timeout")
#				log.exception("write timout")
