import serial
import socket
import sys
import time



if __name__ == "__main__":
	PORT = 2000
	size = 1024

	# connect to serial port
	ser = serial.serial_for_url('/dev/ttyUSB0', do_not_open=True)
	ser.baudrate = 115200

	try:
		ser.open()
	except serial.SerialException as e:
		sys.stderr.write('Could not open serial port {}: {}\n'.format(ser.name, e))
		sys.exit(1)

	server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	# server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
	server_socket.setsockopt(socket.IPPROTO_TCP, socket.TCP_NODELAY, 1)
	server_socket.bind(("130.215.206.208", PORT))
	server_socket.listen(1)

	while 1:
		client, address = server_socket.accept()
		# line = ser.readline()
		# ser = serial.Serial('/dev/ttyUSB0')  # open serial port
		# print(ser.name)
		while 1:
			data = client.recv(size) 
			if data != None:
				print(data)
				ser.write(data)                 # get a bunch of bytes and send them
				data = None

