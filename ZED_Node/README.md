**Setup**

CERBERUS/ZED_Node$ catkin_make

echo source ~/CERBERUS/ZED_Node/devel/setup.bash >> ~/.bashrc

source ~/.bashrc

**Run Node without RVIZ**

roslaunch zed_wrapper zed.launch 

**Run Node with RVIZ**

roslaunch zed_wrapper display.launch 
