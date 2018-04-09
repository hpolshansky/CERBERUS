#!/usr/bin/env python

import rospy
import serial
import pynmea2
from std_msgs.msg import String

def getNextGPS(ser):
    while 1:
		line = ser.readline()
		msg = pynmea2.parse(line,True)
		if '$GPGGA' in line:
			return msg.lat+msg.lat_dir+msg.lon+msg.lon_dir 
		if '$GPGSA' in line:
			if line[9] is '1':
				return "No Fix"
    return "Fail!"

def main():
    gpsPub = rospy.Publisher('GPS_Raw', String, queue_size=10)
    rospy.init_node('RTK_Node', anonymous=True)
    rate = rospy.Rate(10) # 10hz
    ser = serial.Serial(
        port='/dev/ttyACM0',
        baudrate=115200,
        parity=serial.PARITY_NONE,
        stopbits=serial.STOPBITS_ONE,
        bytesize=serial.EIGHTBITS
    )
    ser.isOpen()
    while not rospy.is_shutdown():
        gps_msg = getNextGPS(ser)
        gpsPub.publish(gps_msg)
        rate.sleep()
    ser.close()

if __name__ == '__main__':
    try:
        main()
    except rospy.ROSInterruptException:
        pass
