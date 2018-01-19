#!/bin/sh

if [ -n "$DESTDIR" ] ; then
    case $DESTDIR in
        /*) # ok
            ;;
        *)
            /bin/echo "DESTDIR argument must be absolute... "
            /bin/echo "otherwise python's distutils will bork things."
            exit 1
    esac
    DESTDIR_ARG="--root=$DESTDIR"
fi

echo_and_run() { echo "+ $@" ; "$@" ; }

echo_and_run cd "/home/vargoal/CERBERUS/src/walabot"

# ensure that Python install destination exists
echo_and_run mkdir -p "$DESTDIR/home/vargoal/CERBERUS/install/lib/python2.7/dist-packages"

# Note that PYTHONPATH is pulled from the environment to support installing
# into one location when some dependencies were installed in another
# location, #123.
echo_and_run /usr/bin/env \
    PYTHONPATH="/home/vargoal/CERBERUS/install/lib/python2.7/dist-packages:/home/vargoal/CERBERUS/build/lib/python2.7/dist-packages:$PYTHONPATH" \
    CATKIN_BINARY_DIR="/home/vargoal/CERBERUS/build" \
    "/usr/bin/python" \
    "/home/vargoal/CERBERUS/src/walabot/setup.py" \
    build --build-base "/home/vargoal/CERBERUS/build/walabot" \
    install \
    $DESTDIR_ARG \
    --install-layout=deb --prefix="/home/vargoal/CERBERUS/install" --install-scripts="/home/vargoal/CERBERUS/install/bin"
