
(cl:in-package :asdf)

(defsystem "walabot_msgs-msg"
  :depends-on (:roslisp-msg-protocol :roslisp-utils )
  :components ((:file "_package")
    (:file "walabot_settings" :depends-on ("_package_walabot_settings"))
    (:file "_package_walabot_settings" :depends-on ("_package"))
  ))