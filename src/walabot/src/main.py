#!/usr/bin/env python

import rospy
from std_msgs.msg import Header
from sensor_msgs.msg import Image
from walabot_msgs.msg import walabot_settings
from WalDev import WalDev

class main:
    def __init__(self):
        self.rParams = [50,100,1] #45 - > 46 data
        self.thetaParams = [-1,1,1] #2
        self.phiParams = [-45,45,5] #18 - > data[r]
        self.threshold = 20
        self.mti = 0
        self.msgCount = 0

    def updateWalabotSettings(self):
        self.wlbt.setParams(self.rParams,self.thetaParams,self.phiParams,self.threshold,self.mti)
        self.lenOfPhi, self.lenOfR = self.wlbt.getRawImageSliceDimensions()

    def setting_callback(self,data):
        #TODO: update a global setting object here with new values. Also check they are valid.
        #float32 Threshold
        if((data.R_Min > 10) and (data.R_Min <= 500)):
            self.rParams[0] = data.R_Min
        if((data.R_Max > 20) and (data.R_Max <= 500)):
            self.rParams[1] = data.R_Max
        if((data.R_Res > 1) and (data.R_Max <= 10)):
            self.rParams[2] = data.R_Res
        if((data.Theta_Min > -90) and (data.Theta_Min < 90)):
            self.thetaParams[0] = data.Theta_Min
        if((data.Theta_Max > -90) and (data.Theta_Max < 90)):
            self.thetaParams[1] = data.Theta_Max
        if((data.Theta_Res > 0.1) and (data.Theta_Res <= 10)):
            self.thetaParams[2] = data.Theta_Res
        if((data.Phi_Min > -90) and (data.Phi_Min < 90)):
            self.phiParams[0] = data.Phi_Min
        if((data.Phi_Max > -90) and (data.Phi_Max < 90)):
            self.phiParams[1] = data.Phi_Max
        if((data.Phi_Res > 0.1) and (data.Phi_Res <= 10)):
            self.phiParams[2] = data.Phi_Res
        if((data.Threshold >0.1) and (data.Threshold <100)):
            self.threshold = data.Threshold
        self.updateWalabotSettings()
        rospy.loginfo(rospy.get_caller_id() + "updated params")
        
    def setup_listener(self):
        rospy.Subscriber("walabot_settings", walabot_settings, self.setting_callback)

    def init_wal(self):
        self.wlbt = WalDev()
        if(not self.wlbt.isConnected()):
            print('Unable to connect to walabot')
            exit()
        self.updateWalabotSettings()
        print('Calibrating...')
        self.wlbt.calibrate()

    def init_node(self):
        self.init_wal()
        self.setup_listener()
        self.imgPub = rospy.Publisher('walabot/raw_image', Image, queue_size=10)
        rospy.init_node('walabot', anonymous=True) #initialize ROS node
        print 'Walabot ROS node started'

    def main_loop(self):
        while not rospy.is_shutdown():
            data = self.wlbt.triggerAndGetRawImageSlice()
            rangeBins,phiBins = self.wlbt.getRawImageSliceDimensions()
            newHeader = Header()
            newHeader.seq = self.msgCount+1
            newHeader.stamp.secs = 10#rospy.get_rostime()
            newHeader.stamp.nsecs = 0
            newHeader.frame_id = str(0) #not sure if this should be a 1
            newImg = Image()
            #print type(newImg.data)
            #print newImg.data
            #exit()
            newImg.header = newHeader
            newImg.height = rangeBins
            newImg.width = phiBins
            newImg.encoding = "mono8" #0-255
            newImg.step = phiBins
            newData = []
            for i in range(0,rangeBins):
               for k in range(0,phiBins):
                  newData.append(data[i][k])
            #print len(newData)
            newImg.data = newData
            #print type(data)
            #TODO: setup img
            self.imgPub.publish(newImg)
            self.msgCount = self.msgCount + 1
            #rospy.spin()

if __name__ == '__main__':
    m = main()
    m.init_node()
    m.main_loop()
