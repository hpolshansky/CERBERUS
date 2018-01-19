#!/usr/bin/env python

import rospy
from std_msgs.msg import String
from walabot_msgs.msg import walabot_settings

def setting_callback(data):
    #TODO: update a global setting object here with new values. Also check they are valid.
    rospy.loginfo(rospy.get_caller_id() + "I heard %s", data.R_Min)
    
def setup_listener():
    rospy.Subscriber("walabot_settings", custom, setting_callback)

def init_node():
    rospy.init_node('walabot', anonymous=True) #initialize ROS node
    print 'Hello World'

def main_loop():
    #TODO: trigger and get walabot data
    #TODO: publish data
    rospy.spin()

if __name__ == '__main__':
    init_node()
    main_loop()
