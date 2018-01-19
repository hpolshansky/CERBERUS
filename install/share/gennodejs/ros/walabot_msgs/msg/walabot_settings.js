// Auto-generated. Do not edit!

// (in-package walabot_msgs.msg)


"use strict";

const _serializer = _ros_msg_utils.Serialize;
const _arraySerializer = _serializer.Array;
const _deserializer = _ros_msg_utils.Deserialize;
const _arrayDeserializer = _deserializer.Array;
const _finder = _ros_msg_utils.Find;
const _getByteLength = _ros_msg_utils.getByteLength;

//-----------------------------------------------------------

class walabot_settings {
  constructor(initObj={}) {
    if (initObj === null) {
      // initObj === null is a special case for deserialization where we don't initialize fields
      this.R_Min = null;
      this.R_Max = null;
      this.R_Res = null;
      this.Theta_Min = null;
      this.Theta_Max = null;
      this.Theta_Res = null;
      this.Phi_Min = null;
      this.Phi_Max = null;
      this.Phi_Res = null;
      this.Threshold = null;
    }
    else {
      if (initObj.hasOwnProperty('R_Min')) {
        this.R_Min = initObj.R_Min
      }
      else {
        this.R_Min = 0.0;
      }
      if (initObj.hasOwnProperty('R_Max')) {
        this.R_Max = initObj.R_Max
      }
      else {
        this.R_Max = 0.0;
      }
      if (initObj.hasOwnProperty('R_Res')) {
        this.R_Res = initObj.R_Res
      }
      else {
        this.R_Res = 0.0;
      }
      if (initObj.hasOwnProperty('Theta_Min')) {
        this.Theta_Min = initObj.Theta_Min
      }
      else {
        this.Theta_Min = 0.0;
      }
      if (initObj.hasOwnProperty('Theta_Max')) {
        this.Theta_Max = initObj.Theta_Max
      }
      else {
        this.Theta_Max = 0.0;
      }
      if (initObj.hasOwnProperty('Theta_Res')) {
        this.Theta_Res = initObj.Theta_Res
      }
      else {
        this.Theta_Res = 0.0;
      }
      if (initObj.hasOwnProperty('Phi_Min')) {
        this.Phi_Min = initObj.Phi_Min
      }
      else {
        this.Phi_Min = 0.0;
      }
      if (initObj.hasOwnProperty('Phi_Max')) {
        this.Phi_Max = initObj.Phi_Max
      }
      else {
        this.Phi_Max = 0.0;
      }
      if (initObj.hasOwnProperty('Phi_Res')) {
        this.Phi_Res = initObj.Phi_Res
      }
      else {
        this.Phi_Res = 0.0;
      }
      if (initObj.hasOwnProperty('Threshold')) {
        this.Threshold = initObj.Threshold
      }
      else {
        this.Threshold = 0.0;
      }
    }
  }

  static serialize(obj, buffer, bufferOffset) {
    // Serializes a message object of type walabot_settings
    // Serialize message field [R_Min]
    bufferOffset = _serializer.float32(obj.R_Min, buffer, bufferOffset);
    // Serialize message field [R_Max]
    bufferOffset = _serializer.float32(obj.R_Max, buffer, bufferOffset);
    // Serialize message field [R_Res]
    bufferOffset = _serializer.float32(obj.R_Res, buffer, bufferOffset);
    // Serialize message field [Theta_Min]
    bufferOffset = _serializer.float32(obj.Theta_Min, buffer, bufferOffset);
    // Serialize message field [Theta_Max]
    bufferOffset = _serializer.float32(obj.Theta_Max, buffer, bufferOffset);
    // Serialize message field [Theta_Res]
    bufferOffset = _serializer.float32(obj.Theta_Res, buffer, bufferOffset);
    // Serialize message field [Phi_Min]
    bufferOffset = _serializer.float32(obj.Phi_Min, buffer, bufferOffset);
    // Serialize message field [Phi_Max]
    bufferOffset = _serializer.float32(obj.Phi_Max, buffer, bufferOffset);
    // Serialize message field [Phi_Res]
    bufferOffset = _serializer.float32(obj.Phi_Res, buffer, bufferOffset);
    // Serialize message field [Threshold]
    bufferOffset = _serializer.float32(obj.Threshold, buffer, bufferOffset);
    return bufferOffset;
  }

  static deserialize(buffer, bufferOffset=[0]) {
    //deserializes a message object of type walabot_settings
    let len;
    let data = new walabot_settings(null);
    // Deserialize message field [R_Min]
    data.R_Min = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [R_Max]
    data.R_Max = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [R_Res]
    data.R_Res = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Theta_Min]
    data.Theta_Min = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Theta_Max]
    data.Theta_Max = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Theta_Res]
    data.Theta_Res = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Phi_Min]
    data.Phi_Min = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Phi_Max]
    data.Phi_Max = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Phi_Res]
    data.Phi_Res = _deserializer.float32(buffer, bufferOffset);
    // Deserialize message field [Threshold]
    data.Threshold = _deserializer.float32(buffer, bufferOffset);
    return data;
  }

  static getMessageSize(object) {
    return 40;
  }

  static datatype() {
    // Returns string type for a message object
    return 'walabot_msgs/walabot_settings';
  }

  static md5sum() {
    //Returns md5sum for a message object
    return 'fd215d06f432e497fd301996b833fa32';
  }

  static messageDefinition() {
    // Returns full string definition for message
    return `
    float32 R_Min
    float32 R_Max
    float32 R_Res
    float32 Theta_Min
    float32 Theta_Max
    float32 Theta_Res
    float32 Phi_Min
    float32 Phi_Max
    float32 Phi_Res
    float32 Threshold
    
    `;
  }

  static Resolve(msg) {
    // deep-construct a valid message object instance of whatever was passed in
    if (typeof msg !== 'object' || msg === null) {
      msg = {};
    }
    const resolved = new walabot_settings(null);
    if (msg.R_Min !== undefined) {
      resolved.R_Min = msg.R_Min;
    }
    else {
      resolved.R_Min = 0.0
    }

    if (msg.R_Max !== undefined) {
      resolved.R_Max = msg.R_Max;
    }
    else {
      resolved.R_Max = 0.0
    }

    if (msg.R_Res !== undefined) {
      resolved.R_Res = msg.R_Res;
    }
    else {
      resolved.R_Res = 0.0
    }

    if (msg.Theta_Min !== undefined) {
      resolved.Theta_Min = msg.Theta_Min;
    }
    else {
      resolved.Theta_Min = 0.0
    }

    if (msg.Theta_Max !== undefined) {
      resolved.Theta_Max = msg.Theta_Max;
    }
    else {
      resolved.Theta_Max = 0.0
    }

    if (msg.Theta_Res !== undefined) {
      resolved.Theta_Res = msg.Theta_Res;
    }
    else {
      resolved.Theta_Res = 0.0
    }

    if (msg.Phi_Min !== undefined) {
      resolved.Phi_Min = msg.Phi_Min;
    }
    else {
      resolved.Phi_Min = 0.0
    }

    if (msg.Phi_Max !== undefined) {
      resolved.Phi_Max = msg.Phi_Max;
    }
    else {
      resolved.Phi_Max = 0.0
    }

    if (msg.Phi_Res !== undefined) {
      resolved.Phi_Res = msg.Phi_Res;
    }
    else {
      resolved.Phi_Res = 0.0
    }

    if (msg.Threshold !== undefined) {
      resolved.Threshold = msg.Threshold;
    }
    else {
      resolved.Threshold = 0.0
    }

    return resolved;
    }
};

module.exports = walabot_settings;
