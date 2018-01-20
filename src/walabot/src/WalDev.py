import WalabotAPI as wlbt

class WalDev:
    """ Control the Walabot using the Walabot API.
    """

    def __init__(self):
        """ Init the Walabot API.
        """
        self.wlbt = wlbt
        self.wlbt.Init()
        self.wlbt.SetSettingsFolder()

    def isConnected(self):
        """ Try to connect the Walabot device. Return True/False accordingly.
        """
        try:
            self.wlbt.ConnectAny()
        except self.wlbt.WalabotError as err:
            if err.code == 19:  # "WALABOT_INSTRUMENT_NOT_FOUND"
                return False
            else:
                raise err
        return True

    def setParams(self, r, theta, phi, threshold, mti):
        """ Set the arena Parameters according given ones.
        """
        # params are arrays
        self.wlbt.SetProfile(self.wlbt.PROF_SENSOR)
        self.wlbt.SetArenaR(*r)
        self.wlbt.SetArenaTheta(*theta)
        self.wlbt.SetArenaPhi(*phi)
        self.wlbt.SetThreshold(threshold)
        self.wlbt.SetDynamicImageFilter(mti)
        self.wlbt.Start()

    def getArenaParams(self):
        """ Returns the Walabot parameters from the Walabot SDK.
            Returns:
                params      rParams, thetaParams, phiParams, threshold as
                            given from the Walabot SDK.
        """
        rParams = self.wlbt.GetArenaR()
        thetaParams = self.wlbt.GetArenaTheta()
        phiParams = self.wlbt.GetArenaPhi()
        threshold = self.wlbt.GetThreshold()
        return rParams, thetaParams, phiParams, threshold

    def calibrate(self):
        """ Calibrates the Walabot.
        """
        self.wlbt.StartCalibration()
        while self.wlbt.GetStatus()[0] == self.wlbt.STATUS_CALIBRATING:
            self.wlbt.Trigger()

    def getRawImageSliceDimensions(self):
        """ Returns the dimensions of the rawImage 2D list given from the
            Walabot SDK.
            Returns:
                lenOfPhi    Num of cells in Phi axis.
                lenOfR      Num of cells in Theta axis.
        """
        return self.wlbt.GetRawImageSlice()[1:3]

    def triggerAndGetRawImageSlice(self):
        """ Returns the rawImage given from the Walabot SDK.
            Returns:
                rawImage    A rawImage list as described in the Walabot docs.
        """
        self.wlbt.Trigger()
        return self.wlbt.GetRawImageSlice()[0]

    def getFps(self):
        """ Returns the Walabot current fps as given from the Walabot SDK.
            Returns:
                fpsVar      Number of frames per seconds.
        """
        return int(self.wlbt.GetAdvancedParameter('FrameRate'))

