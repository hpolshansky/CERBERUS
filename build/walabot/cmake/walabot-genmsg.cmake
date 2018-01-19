# generated from genmsg/cmake/pkg-genmsg.cmake.em

message(STATUS "walabot: 1 messages, 0 services")

set(MSG_I_FLAGS "-Iwalabot:/home/vargoal/CERBERUS/src/walabot/msg;-Istd_msgs:/opt/ros/kinetic/share/std_msgs/cmake/../msg")

# Find all generators
find_package(gencpp REQUIRED)
find_package(geneus REQUIRED)
find_package(genlisp REQUIRED)
find_package(gennodejs REQUIRED)
find_package(genpy REQUIRED)

add_custom_target(walabot_generate_messages ALL)

# verify that message/service dependencies have not changed since configure



get_filename_component(_filename "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" NAME_WE)
add_custom_target(_walabot_generate_messages_check_deps_${_filename}
  COMMAND ${CATKIN_ENV} ${PYTHON_EXECUTABLE} ${GENMSG_CHECK_DEPS_SCRIPT} "walabot" "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" ""
)

#
#  langs = gencpp;geneus;genlisp;gennodejs;genpy
#

### Section generating for lang: gencpp
### Generating Messages
_generate_msg_cpp(walabot
  "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg"
  "${MSG_I_FLAGS}"
  ""
  ${CATKIN_DEVEL_PREFIX}/${gencpp_INSTALL_DIR}/walabot
)

### Generating Services

### Generating Module File
_generate_module_cpp(walabot
  ${CATKIN_DEVEL_PREFIX}/${gencpp_INSTALL_DIR}/walabot
  "${ALL_GEN_OUTPUT_FILES_cpp}"
)

add_custom_target(walabot_generate_messages_cpp
  DEPENDS ${ALL_GEN_OUTPUT_FILES_cpp}
)
add_dependencies(walabot_generate_messages walabot_generate_messages_cpp)

# add dependencies to all check dependencies targets
get_filename_component(_filename "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" NAME_WE)
add_dependencies(walabot_generate_messages_cpp _walabot_generate_messages_check_deps_${_filename})

# target for backward compatibility
add_custom_target(walabot_gencpp)
add_dependencies(walabot_gencpp walabot_generate_messages_cpp)

# register target for catkin_package(EXPORTED_TARGETS)
list(APPEND ${PROJECT_NAME}_EXPORTED_TARGETS walabot_generate_messages_cpp)

### Section generating for lang: geneus
### Generating Messages
_generate_msg_eus(walabot
  "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg"
  "${MSG_I_FLAGS}"
  ""
  ${CATKIN_DEVEL_PREFIX}/${geneus_INSTALL_DIR}/walabot
)

### Generating Services

### Generating Module File
_generate_module_eus(walabot
  ${CATKIN_DEVEL_PREFIX}/${geneus_INSTALL_DIR}/walabot
  "${ALL_GEN_OUTPUT_FILES_eus}"
)

add_custom_target(walabot_generate_messages_eus
  DEPENDS ${ALL_GEN_OUTPUT_FILES_eus}
)
add_dependencies(walabot_generate_messages walabot_generate_messages_eus)

# add dependencies to all check dependencies targets
get_filename_component(_filename "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" NAME_WE)
add_dependencies(walabot_generate_messages_eus _walabot_generate_messages_check_deps_${_filename})

# target for backward compatibility
add_custom_target(walabot_geneus)
add_dependencies(walabot_geneus walabot_generate_messages_eus)

# register target for catkin_package(EXPORTED_TARGETS)
list(APPEND ${PROJECT_NAME}_EXPORTED_TARGETS walabot_generate_messages_eus)

### Section generating for lang: genlisp
### Generating Messages
_generate_msg_lisp(walabot
  "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg"
  "${MSG_I_FLAGS}"
  ""
  ${CATKIN_DEVEL_PREFIX}/${genlisp_INSTALL_DIR}/walabot
)

### Generating Services

### Generating Module File
_generate_module_lisp(walabot
  ${CATKIN_DEVEL_PREFIX}/${genlisp_INSTALL_DIR}/walabot
  "${ALL_GEN_OUTPUT_FILES_lisp}"
)

add_custom_target(walabot_generate_messages_lisp
  DEPENDS ${ALL_GEN_OUTPUT_FILES_lisp}
)
add_dependencies(walabot_generate_messages walabot_generate_messages_lisp)

# add dependencies to all check dependencies targets
get_filename_component(_filename "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" NAME_WE)
add_dependencies(walabot_generate_messages_lisp _walabot_generate_messages_check_deps_${_filename})

# target for backward compatibility
add_custom_target(walabot_genlisp)
add_dependencies(walabot_genlisp walabot_generate_messages_lisp)

# register target for catkin_package(EXPORTED_TARGETS)
list(APPEND ${PROJECT_NAME}_EXPORTED_TARGETS walabot_generate_messages_lisp)

### Section generating for lang: gennodejs
### Generating Messages
_generate_msg_nodejs(walabot
  "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg"
  "${MSG_I_FLAGS}"
  ""
  ${CATKIN_DEVEL_PREFIX}/${gennodejs_INSTALL_DIR}/walabot
)

### Generating Services

### Generating Module File
_generate_module_nodejs(walabot
  ${CATKIN_DEVEL_PREFIX}/${gennodejs_INSTALL_DIR}/walabot
  "${ALL_GEN_OUTPUT_FILES_nodejs}"
)

add_custom_target(walabot_generate_messages_nodejs
  DEPENDS ${ALL_GEN_OUTPUT_FILES_nodejs}
)
add_dependencies(walabot_generate_messages walabot_generate_messages_nodejs)

# add dependencies to all check dependencies targets
get_filename_component(_filename "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" NAME_WE)
add_dependencies(walabot_generate_messages_nodejs _walabot_generate_messages_check_deps_${_filename})

# target for backward compatibility
add_custom_target(walabot_gennodejs)
add_dependencies(walabot_gennodejs walabot_generate_messages_nodejs)

# register target for catkin_package(EXPORTED_TARGETS)
list(APPEND ${PROJECT_NAME}_EXPORTED_TARGETS walabot_generate_messages_nodejs)

### Section generating for lang: genpy
### Generating Messages
_generate_msg_py(walabot
  "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg"
  "${MSG_I_FLAGS}"
  ""
  ${CATKIN_DEVEL_PREFIX}/${genpy_INSTALL_DIR}/walabot
)

### Generating Services

### Generating Module File
_generate_module_py(walabot
  ${CATKIN_DEVEL_PREFIX}/${genpy_INSTALL_DIR}/walabot
  "${ALL_GEN_OUTPUT_FILES_py}"
)

add_custom_target(walabot_generate_messages_py
  DEPENDS ${ALL_GEN_OUTPUT_FILES_py}
)
add_dependencies(walabot_generate_messages walabot_generate_messages_py)

# add dependencies to all check dependencies targets
get_filename_component(_filename "/home/vargoal/CERBERUS/src/walabot/msg/custom.msg" NAME_WE)
add_dependencies(walabot_generate_messages_py _walabot_generate_messages_check_deps_${_filename})

# target for backward compatibility
add_custom_target(walabot_genpy)
add_dependencies(walabot_genpy walabot_generate_messages_py)

# register target for catkin_package(EXPORTED_TARGETS)
list(APPEND ${PROJECT_NAME}_EXPORTED_TARGETS walabot_generate_messages_py)



if(gencpp_INSTALL_DIR AND EXISTS ${CATKIN_DEVEL_PREFIX}/${gencpp_INSTALL_DIR}/walabot)
  # install generated code
  install(
    DIRECTORY ${CATKIN_DEVEL_PREFIX}/${gencpp_INSTALL_DIR}/walabot
    DESTINATION ${gencpp_INSTALL_DIR}
  )
endif()
if(TARGET std_msgs_generate_messages_cpp)
  add_dependencies(walabot_generate_messages_cpp std_msgs_generate_messages_cpp)
endif()

if(geneus_INSTALL_DIR AND EXISTS ${CATKIN_DEVEL_PREFIX}/${geneus_INSTALL_DIR}/walabot)
  # install generated code
  install(
    DIRECTORY ${CATKIN_DEVEL_PREFIX}/${geneus_INSTALL_DIR}/walabot
    DESTINATION ${geneus_INSTALL_DIR}
  )
endif()
if(TARGET std_msgs_generate_messages_eus)
  add_dependencies(walabot_generate_messages_eus std_msgs_generate_messages_eus)
endif()

if(genlisp_INSTALL_DIR AND EXISTS ${CATKIN_DEVEL_PREFIX}/${genlisp_INSTALL_DIR}/walabot)
  # install generated code
  install(
    DIRECTORY ${CATKIN_DEVEL_PREFIX}/${genlisp_INSTALL_DIR}/walabot
    DESTINATION ${genlisp_INSTALL_DIR}
  )
endif()
if(TARGET std_msgs_generate_messages_lisp)
  add_dependencies(walabot_generate_messages_lisp std_msgs_generate_messages_lisp)
endif()

if(gennodejs_INSTALL_DIR AND EXISTS ${CATKIN_DEVEL_PREFIX}/${gennodejs_INSTALL_DIR}/walabot)
  # install generated code
  install(
    DIRECTORY ${CATKIN_DEVEL_PREFIX}/${gennodejs_INSTALL_DIR}/walabot
    DESTINATION ${gennodejs_INSTALL_DIR}
  )
endif()
if(TARGET std_msgs_generate_messages_nodejs)
  add_dependencies(walabot_generate_messages_nodejs std_msgs_generate_messages_nodejs)
endif()

if(genpy_INSTALL_DIR AND EXISTS ${CATKIN_DEVEL_PREFIX}/${genpy_INSTALL_DIR}/walabot)
  install(CODE "execute_process(COMMAND \"/usr/bin/python\" -m compileall \"${CATKIN_DEVEL_PREFIX}/${genpy_INSTALL_DIR}/walabot\")")
  # install generated code
  install(
    DIRECTORY ${CATKIN_DEVEL_PREFIX}/${genpy_INSTALL_DIR}/walabot
    DESTINATION ${genpy_INSTALL_DIR}
  )
endif()
if(TARGET std_msgs_generate_messages_py)
  add_dependencies(walabot_generate_messages_py std_msgs_generate_messages_py)
endif()
