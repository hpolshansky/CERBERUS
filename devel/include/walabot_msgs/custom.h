// Generated by gencpp from file walabot_msgs/custom.msg
// DO NOT EDIT!


#ifndef WALABOT_MSGS_MESSAGE_CUSTOM_H
#define WALABOT_MSGS_MESSAGE_CUSTOM_H


#include <string>
#include <vector>
#include <map>

#include <ros/types.h>
#include <ros/serialization.h>
#include <ros/builtin_message_traits.h>
#include <ros/message_operations.h>


namespace walabot_msgs
{
template <class ContainerAllocator>
struct custom_
{
  typedef custom_<ContainerAllocator> Type;

  custom_()
    : R_Min(0.0)
    , R_Max(0.0)
    , R_Res(0.0)
    , Theta_Min(0.0)
    , Theta_Max(0.0)
    , Theta_Res(0.0)
    , Phi_Min(0.0)
    , Phi_Max(0.0)
    , Phi_Res(0.0)
    , Threshold(0.0)  {
    }
  custom_(const ContainerAllocator& _alloc)
    : R_Min(0.0)
    , R_Max(0.0)
    , R_Res(0.0)
    , Theta_Min(0.0)
    , Theta_Max(0.0)
    , Theta_Res(0.0)
    , Phi_Min(0.0)
    , Phi_Max(0.0)
    , Phi_Res(0.0)
    , Threshold(0.0)  {
  (void)_alloc;
    }



   typedef float _R_Min_type;
  _R_Min_type R_Min;

   typedef float _R_Max_type;
  _R_Max_type R_Max;

   typedef float _R_Res_type;
  _R_Res_type R_Res;

   typedef float _Theta_Min_type;
  _Theta_Min_type Theta_Min;

   typedef float _Theta_Max_type;
  _Theta_Max_type Theta_Max;

   typedef float _Theta_Res_type;
  _Theta_Res_type Theta_Res;

   typedef float _Phi_Min_type;
  _Phi_Min_type Phi_Min;

   typedef float _Phi_Max_type;
  _Phi_Max_type Phi_Max;

   typedef float _Phi_Res_type;
  _Phi_Res_type Phi_Res;

   typedef float _Threshold_type;
  _Threshold_type Threshold;




  typedef boost::shared_ptr< ::walabot_msgs::custom_<ContainerAllocator> > Ptr;
  typedef boost::shared_ptr< ::walabot_msgs::custom_<ContainerAllocator> const> ConstPtr;

}; // struct custom_

typedef ::walabot_msgs::custom_<std::allocator<void> > custom;

typedef boost::shared_ptr< ::walabot_msgs::custom > customPtr;
typedef boost::shared_ptr< ::walabot_msgs::custom const> customConstPtr;

// constants requiring out of line definition



template<typename ContainerAllocator>
std::ostream& operator<<(std::ostream& s, const ::walabot_msgs::custom_<ContainerAllocator> & v)
{
ros::message_operations::Printer< ::walabot_msgs::custom_<ContainerAllocator> >::stream(s, "", v);
return s;
}

} // namespace walabot_msgs

namespace ros
{
namespace message_traits
{



// BOOLTRAITS {'IsFixedSize': True, 'IsMessage': True, 'HasHeader': False}
// {'std_msgs': ['/opt/ros/kinetic/share/std_msgs/cmake/../msg'], 'walabot_msgs': ['/home/vargoal/CERBERUS/src/walabot_msgs/msg']}

// !!!!!!!!!!! ['__class__', '__delattr__', '__dict__', '__doc__', '__eq__', '__format__', '__getattribute__', '__hash__', '__init__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', '_parsed_fields', 'constants', 'fields', 'full_name', 'has_header', 'header_present', 'names', 'package', 'parsed_fields', 'short_name', 'text', 'types']




template <class ContainerAllocator>
struct IsFixedSize< ::walabot_msgs::custom_<ContainerAllocator> >
  : TrueType
  { };

template <class ContainerAllocator>
struct IsFixedSize< ::walabot_msgs::custom_<ContainerAllocator> const>
  : TrueType
  { };

template <class ContainerAllocator>
struct IsMessage< ::walabot_msgs::custom_<ContainerAllocator> >
  : TrueType
  { };

template <class ContainerAllocator>
struct IsMessage< ::walabot_msgs::custom_<ContainerAllocator> const>
  : TrueType
  { };

template <class ContainerAllocator>
struct HasHeader< ::walabot_msgs::custom_<ContainerAllocator> >
  : FalseType
  { };

template <class ContainerAllocator>
struct HasHeader< ::walabot_msgs::custom_<ContainerAllocator> const>
  : FalseType
  { };


template<class ContainerAllocator>
struct MD5Sum< ::walabot_msgs::custom_<ContainerAllocator> >
{
  static const char* value()
  {
    return "fd215d06f432e497fd301996b833fa32";
  }

  static const char* value(const ::walabot_msgs::custom_<ContainerAllocator>&) { return value(); }
  static const uint64_t static_value1 = 0xfd215d06f432e497ULL;
  static const uint64_t static_value2 = 0xfd301996b833fa32ULL;
};

template<class ContainerAllocator>
struct DataType< ::walabot_msgs::custom_<ContainerAllocator> >
{
  static const char* value()
  {
    return "walabot_msgs/custom";
  }

  static const char* value(const ::walabot_msgs::custom_<ContainerAllocator>&) { return value(); }
};

template<class ContainerAllocator>
struct Definition< ::walabot_msgs::custom_<ContainerAllocator> >
{
  static const char* value()
  {
    return "float32 R_Min\n\
float32 R_Max\n\
float32 R_Res\n\
float32 Theta_Min\n\
float32 Theta_Max\n\
float32 Theta_Res\n\
float32 Phi_Min\n\
float32 Phi_Max\n\
float32 Phi_Res\n\
float32 Threshold\n\
";
  }

  static const char* value(const ::walabot_msgs::custom_<ContainerAllocator>&) { return value(); }
};

} // namespace message_traits
} // namespace ros

namespace ros
{
namespace serialization
{

  template<class ContainerAllocator> struct Serializer< ::walabot_msgs::custom_<ContainerAllocator> >
  {
    template<typename Stream, typename T> inline static void allInOne(Stream& stream, T m)
    {
      stream.next(m.R_Min);
      stream.next(m.R_Max);
      stream.next(m.R_Res);
      stream.next(m.Theta_Min);
      stream.next(m.Theta_Max);
      stream.next(m.Theta_Res);
      stream.next(m.Phi_Min);
      stream.next(m.Phi_Max);
      stream.next(m.Phi_Res);
      stream.next(m.Threshold);
    }

    ROS_DECLARE_ALLINONE_SERIALIZER
  }; // struct custom_

} // namespace serialization
} // namespace ros

namespace ros
{
namespace message_operations
{

template<class ContainerAllocator>
struct Printer< ::walabot_msgs::custom_<ContainerAllocator> >
{
  template<typename Stream> static void stream(Stream& s, const std::string& indent, const ::walabot_msgs::custom_<ContainerAllocator>& v)
  {
    s << indent << "R_Min: ";
    Printer<float>::stream(s, indent + "  ", v.R_Min);
    s << indent << "R_Max: ";
    Printer<float>::stream(s, indent + "  ", v.R_Max);
    s << indent << "R_Res: ";
    Printer<float>::stream(s, indent + "  ", v.R_Res);
    s << indent << "Theta_Min: ";
    Printer<float>::stream(s, indent + "  ", v.Theta_Min);
    s << indent << "Theta_Max: ";
    Printer<float>::stream(s, indent + "  ", v.Theta_Max);
    s << indent << "Theta_Res: ";
    Printer<float>::stream(s, indent + "  ", v.Theta_Res);
    s << indent << "Phi_Min: ";
    Printer<float>::stream(s, indent + "  ", v.Phi_Min);
    s << indent << "Phi_Max: ";
    Printer<float>::stream(s, indent + "  ", v.Phi_Max);
    s << indent << "Phi_Res: ";
    Printer<float>::stream(s, indent + "  ", v.Phi_Res);
    s << indent << "Threshold: ";
    Printer<float>::stream(s, indent + "  ", v.Threshold);
  }
};

} // namespace message_operations
} // namespace ros

#endif // WALABOT_MSGS_MESSAGE_CUSTOM_H
