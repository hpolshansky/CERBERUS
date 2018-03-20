import serial
import socket
import sys
import time

if __name__ == "__main__":
	PORT = 2000
	IPADDR = "192.168.1.66" #IP ADDR
	size = 16

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
		while 1:
			try:
				data = client.recv(size)
				if not data:
					raise KeyboardInterrupt
				if data != None:
					# print(data)
					ser.write(data)
					data = None

			except KeyboardInterrupt:
				client.close()
				continue
