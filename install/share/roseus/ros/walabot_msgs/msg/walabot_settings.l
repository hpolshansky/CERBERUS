;; Auto-generated. Do not edit!


(when (boundp 'walabot_msgs::walabot_settings)
  (if (not (find-package "WALABOT_MSGS"))
    (make-package "WALABOT_MSGS"))
  (shadow 'walabot_settings (find-package "WALABOT_MSGS")))
(unless (find-package "WALABOT_MSGS::WALABOT_SETTINGS")
  (make-package "WALABOT_MSGS::WALABOT_SETTINGS"))

(in-package "ROS")
;;//! \htmlinclude walabot_settings.msg.html


(defclass walabot_msgs::walabot_settings
  :super ros::object
  :slots (_R_Min _R_Max _R_Res _Theta_Min _Theta_Max _Theta_Res _Phi_Min _Phi_Max _Phi_Res _Threshold ))

(defmethod walabot_msgs::walabot_settings
  (:init
   (&key
    ((:R_Min __R_Min) 0.0)
    ((:R_Max __R_Max) 0.0)
    ((:R_Res __R_Res) 0.0)
    ((:Theta_Min __Theta_Min) 0.0)
    ((:Theta_Max __Theta_Max) 0.0)
    ((:Theta_Res __Theta_Res) 0.0)
    ((:Phi_Min __Phi_Min) 0.0)
    ((:Phi_Max __Phi_Max) 0.0)
    ((:Phi_Res __Phi_Res) 0.0)
    ((:Threshold __Threshold) 0.0)
    )
   (send-super :init)
   (setq _R_Min (float __R_Min))
   (setq _R_Max (float __R_Max))
   (setq _R_Res (float __R_Res))
   (setq _Theta_Min (float __Theta_Min))
   (setq _Theta_Max (float __Theta_Max))
   (setq _Theta_Res (float __Theta_Res))
   (setq _Phi_Min (float __Phi_Min))
   (setq _Phi_Max (float __Phi_Max))
   (setq _Phi_Res (float __Phi_Res))
   (setq _Threshold (float __Threshold))
   self)
  (:R_Min
   (&optional __R_Min)
   (if __R_Min (setq _R_Min __R_Min)) _R_Min)
  (:R_Max
   (&optional __R_Max)
   (if __R_Max (setq _R_Max __R_Max)) _R_Max)
  (:R_Res
   (&optional __R_Res)
   (if __R_Res (setq _R_Res __R_Res)) _R_Res)
  (:Theta_Min
   (&optional __Theta_Min)
   (if __Theta_Min (setq _Theta_Min __Theta_Min)) _Theta_Min)
  (:Theta_Max
   (&optional __Theta_Max)
   (if __Theta_Max (setq _Theta_Max __Theta_Max)) _Theta_Max)
  (:Theta_Res
   (&optional __Theta_Res)
   (if __Theta_Res (setq _Theta_Res __Theta_Res)) _Theta_Res)
  (:Phi_Min
   (&optional __Phi_Min)
   (if __Phi_Min (setq _Phi_Min __Phi_Min)) _Phi_Min)
  (:Phi_Max
   (&optional __Phi_Max)
   (if __Phi_Max (setq _Phi_Max __Phi_Max)) _Phi_Max)
  (:Phi_Res
   (&optional __Phi_Res)
   (if __Phi_Res (setq _Phi_Res __Phi_Res)) _Phi_Res)
  (:Threshold
   (&optional __Threshold)
   (if __Threshold (setq _Threshold __Threshold)) _Threshold)
  (:serialization-length
   ()
   (+
    ;; float32 _R_Min
    4
    ;; float32 _R_Max
    4
    ;; float32 _R_Res
    4
    ;; float32 _Theta_Min
    4
    ;; float32 _Theta_Max
    4
    ;; float32 _Theta_Res
    4
    ;; float32 _Phi_Min
    4
    ;; float32 _Phi_Max
    4
    ;; float32 _Phi_Res
    4
    ;; float32 _Threshold
    4
    ))
  (:serialize
   (&optional strm)
   (let ((s (if strm strm
              (make-string-output-stream (send self :serialization-length)))))
     ;; float32 _R_Min
       (sys::poke _R_Min (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _R_Max
       (sys::poke _R_Max (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _R_Res
       (sys::poke _R_Res (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Theta_Min
       (sys::poke _Theta_Min (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Theta_Max
       (sys::poke _Theta_Max (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Theta_Res
       (sys::poke _Theta_Res (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Phi_Min
       (sys::poke _Phi_Min (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Phi_Max
       (sys::poke _Phi_Max (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Phi_Res
       (sys::poke _Phi_Res (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;; float32 _Threshold
       (sys::poke _Threshold (send s :buffer) (send s :count) :float) (incf (stream-count s) 4)
     ;;
     (if (null strm) (get-output-stream-string s))))
  (:deserialize
   (buf &optional (ptr- 0))
   ;; float32 _R_Min
     (setq _R_Min (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _R_Max
     (setq _R_Max (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _R_Res
     (setq _R_Res (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Theta_Min
     (setq _Theta_Min (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Theta_Max
     (setq _Theta_Max (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Theta_Res
     (setq _Theta_Res (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Phi_Min
     (setq _Phi_Min (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Phi_Max
     (setq _Phi_Max (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Phi_Res
     (setq _Phi_Res (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;; float32 _Threshold
     (setq _Threshold (sys::peek buf ptr- :float)) (incf ptr- 4)
   ;;
   self)
  )

(setf (get walabot_msgs::walabot_settings :md5sum-) "fd215d06f432e497fd301996b833fa32")
(setf (get walabot_msgs::walabot_settings :datatype-) "walabot_msgs/walabot_settings")
(setf (get walabot_msgs::walabot_settings :definition-)
      "float32 R_Min
float32 R_Max
float32 R_Res
float32 Theta_Min
float32 Theta_Max
float32 Theta_Res
float32 Phi_Min
float32 Phi_Max
float32 Phi_Res
float32 Threshold

")



(provide :walabot_msgs/walabot_settings "fd215d06f432e497fd301996b833fa32")


