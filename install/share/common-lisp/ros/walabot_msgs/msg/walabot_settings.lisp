; Auto-generated. Do not edit!


(cl:in-package walabot_msgs-msg)


;//! \htmlinclude walabot_settings.msg.html

(cl:defclass <walabot_settings> (roslisp-msg-protocol:ros-message)
  ((R_Min
    :reader R_Min
    :initarg :R_Min
    :type cl:float
    :initform 0.0)
   (R_Max
    :reader R_Max
    :initarg :R_Max
    :type cl:float
    :initform 0.0)
   (R_Res
    :reader R_Res
    :initarg :R_Res
    :type cl:float
    :initform 0.0)
   (Theta_Min
    :reader Theta_Min
    :initarg :Theta_Min
    :type cl:float
    :initform 0.0)
   (Theta_Max
    :reader Theta_Max
    :initarg :Theta_Max
    :type cl:float
    :initform 0.0)
   (Theta_Res
    :reader Theta_Res
    :initarg :Theta_Res
    :type cl:float
    :initform 0.0)
   (Phi_Min
    :reader Phi_Min
    :initarg :Phi_Min
    :type cl:float
    :initform 0.0)
   (Phi_Max
    :reader Phi_Max
    :initarg :Phi_Max
    :type cl:float
    :initform 0.0)
   (Phi_Res
    :reader Phi_Res
    :initarg :Phi_Res
    :type cl:float
    :initform 0.0)
   (Threshold
    :reader Threshold
    :initarg :Threshold
    :type cl:float
    :initform 0.0))
)

(cl:defclass walabot_settings (<walabot_settings>)
  ())

(cl:defmethod cl:initialize-instance :after ((m <walabot_settings>) cl:&rest args)
  (cl:declare (cl:ignorable args))
  (cl:unless (cl:typep m 'walabot_settings)
    (roslisp-msg-protocol:msg-deprecation-warning "using old message class name walabot_msgs-msg:<walabot_settings> is deprecated: use walabot_msgs-msg:walabot_settings instead.")))

(cl:ensure-generic-function 'R_Min-val :lambda-list '(m))
(cl:defmethod R_Min-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:R_Min-val is deprecated.  Use walabot_msgs-msg:R_Min instead.")
  (R_Min m))

(cl:ensure-generic-function 'R_Max-val :lambda-list '(m))
(cl:defmethod R_Max-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:R_Max-val is deprecated.  Use walabot_msgs-msg:R_Max instead.")
  (R_Max m))

(cl:ensure-generic-function 'R_Res-val :lambda-list '(m))
(cl:defmethod R_Res-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:R_Res-val is deprecated.  Use walabot_msgs-msg:R_Res instead.")
  (R_Res m))

(cl:ensure-generic-function 'Theta_Min-val :lambda-list '(m))
(cl:defmethod Theta_Min-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Theta_Min-val is deprecated.  Use walabot_msgs-msg:Theta_Min instead.")
  (Theta_Min m))

(cl:ensure-generic-function 'Theta_Max-val :lambda-list '(m))
(cl:defmethod Theta_Max-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Theta_Max-val is deprecated.  Use walabot_msgs-msg:Theta_Max instead.")
  (Theta_Max m))

(cl:ensure-generic-function 'Theta_Res-val :lambda-list '(m))
(cl:defmethod Theta_Res-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Theta_Res-val is deprecated.  Use walabot_msgs-msg:Theta_Res instead.")
  (Theta_Res m))

(cl:ensure-generic-function 'Phi_Min-val :lambda-list '(m))
(cl:defmethod Phi_Min-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Phi_Min-val is deprecated.  Use walabot_msgs-msg:Phi_Min instead.")
  (Phi_Min m))

(cl:ensure-generic-function 'Phi_Max-val :lambda-list '(m))
(cl:defmethod Phi_Max-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Phi_Max-val is deprecated.  Use walabot_msgs-msg:Phi_Max instead.")
  (Phi_Max m))

(cl:ensure-generic-function 'Phi_Res-val :lambda-list '(m))
(cl:defmethod Phi_Res-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Phi_Res-val is deprecated.  Use walabot_msgs-msg:Phi_Res instead.")
  (Phi_Res m))

(cl:ensure-generic-function 'Threshold-val :lambda-list '(m))
(cl:defmethod Threshold-val ((m <walabot_settings>))
  (roslisp-msg-protocol:msg-deprecation-warning "Using old-style slot reader walabot_msgs-msg:Threshold-val is deprecated.  Use walabot_msgs-msg:Threshold instead.")
  (Threshold m))
(cl:defmethod roslisp-msg-protocol:serialize ((msg <walabot_settings>) ostream)
  "Serializes a message object of type '<walabot_settings>"
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'R_Min))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'R_Max))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'R_Res))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Theta_Min))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Theta_Max))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Theta_Res))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Phi_Min))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Phi_Max))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Phi_Res))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
  (cl:let ((bits (roslisp-utils:encode-single-float-bits (cl:slot-value msg 'Threshold))))
    (cl:write-byte (cl:ldb (cl:byte 8 0) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 8) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 16) bits) ostream)
    (cl:write-byte (cl:ldb (cl:byte 8 24) bits) ostream))
)
(cl:defmethod roslisp-msg-protocol:deserialize ((msg <walabot_settings>) istream)
  "Deserializes a message object of type '<walabot_settings>"
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'R_Min) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'R_Max) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'R_Res) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Theta_Min) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Theta_Max) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Theta_Res) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Phi_Min) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Phi_Max) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Phi_Res) (roslisp-utils:decode-single-float-bits bits)))
    (cl:let ((bits 0))
      (cl:setf (cl:ldb (cl:byte 8 0) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 8) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 16) bits) (cl:read-byte istream))
      (cl:setf (cl:ldb (cl:byte 8 24) bits) (cl:read-byte istream))
    (cl:setf (cl:slot-value msg 'Threshold) (roslisp-utils:decode-single-float-bits bits)))
  msg
)
(cl:defmethod roslisp-msg-protocol:ros-datatype ((msg (cl:eql '<walabot_settings>)))
  "Returns string type for a message object of type '<walabot_settings>"
  "walabot_msgs/walabot_settings")
(cl:defmethod roslisp-msg-protocol:ros-datatype ((msg (cl:eql 'walabot_settings)))
  "Returns string type for a message object of type 'walabot_settings"
  "walabot_msgs/walabot_settings")
(cl:defmethod roslisp-msg-protocol:md5sum ((type (cl:eql '<walabot_settings>)))
  "Returns md5sum for a message object of type '<walabot_settings>"
  "fd215d06f432e497fd301996b833fa32")
(cl:defmethod roslisp-msg-protocol:md5sum ((type (cl:eql 'walabot_settings)))
  "Returns md5sum for a message object of type 'walabot_settings"
  "fd215d06f432e497fd301996b833fa32")
(cl:defmethod roslisp-msg-protocol:message-definition ((type (cl:eql '<walabot_settings>)))
  "Returns full string definition for message of type '<walabot_settings>"
  (cl:format cl:nil "float32 R_Min~%float32 R_Max~%float32 R_Res~%float32 Theta_Min~%float32 Theta_Max~%float32 Theta_Res~%float32 Phi_Min~%float32 Phi_Max~%float32 Phi_Res~%float32 Threshold~%~%~%"))
(cl:defmethod roslisp-msg-protocol:message-definition ((type (cl:eql 'walabot_settings)))
  "Returns full string definition for message of type 'walabot_settings"
  (cl:format cl:nil "float32 R_Min~%float32 R_Max~%float32 R_Res~%float32 Theta_Min~%float32 Theta_Max~%float32 Theta_Res~%float32 Phi_Min~%float32 Phi_Max~%float32 Phi_Res~%float32 Threshold~%~%~%"))
(cl:defmethod roslisp-msg-protocol:serialization-length ((msg <walabot_settings>))
  (cl:+ 0
     4
     4
     4
     4
     4
     4
     4
     4
     4
     4
))
(cl:defmethod roslisp-msg-protocol:ros-message-to-list ((msg <walabot_settings>))
  "Converts a ROS message object to a list"
  (cl:list 'walabot_settings
    (cl:cons ':R_Min (R_Min msg))
    (cl:cons ':R_Max (R_Max msg))
    (cl:cons ':R_Res (R_Res msg))
    (cl:cons ':Theta_Min (Theta_Min msg))
    (cl:cons ':Theta_Max (Theta_Max msg))
    (cl:cons ':Theta_Res (Theta_Res msg))
    (cl:cons ':Phi_Min (Phi_Min msg))
    (cl:cons ':Phi_Max (Phi_Max msg))
    (cl:cons ':Phi_Res (Phi_Res msg))
    (cl:cons ':Threshold (Threshold msg))
))
