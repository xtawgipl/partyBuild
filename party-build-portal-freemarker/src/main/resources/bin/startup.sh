#!/bin/bash

echo "  _             _ _        _              __  __ _      ";
echo " | |           | (_)      | |            / _|/ _(_)     ";
echo " | |_ _   _  __| |_  ___  | |_ _ __ __ _| |_| |_ _  ___ ";
echo " | __| | | |/ _\` | |/ __| | __| '__/ _\` |  _|  _| |/ __|";
echo " | |_| |_| | (_| | | (__  | |_| | | (_| | | | | | | (__ ";
echo "  \__|\__, |\__,_|_|\___|  \__|_|  \__,_|_| |_| |_|\___|";
echo "       __/ |                                            ";
echo "      |___/                                             ";
echo ""
echo ""

MAIN_CLASS="org.springframework.boot.loader.JarLauncher"
EXEC="exec"
BASE_HOME=$(cd $(dirname $0)/..; pwd)

JAVA_HOME=$JAVA_HOME
PRO_CLASSPATH=""
JAVA_OPTS="-Xms50m -Xmx100m"

__evnpath=$BASE_HOME"/bin/application-env.sh"
if [ ! -f "$__evnpath" ]; then
    echo "error: $__evnpath 配置文件文件不存在!"
    exit 0
else
    echo "info:  source $__evnpath"
    source $__evnpath
fi


echo "BASE_HOME="$BASE_HOME
echo "JAVA_HOME="$JAVA_HOME
echo "JAVA_OPTS="$JAVA_OPTS
echo "PRO_CLASSPATH="$PRO_CLASSPATH
echo "INSTANCEID="$INSTANCEID
echo "MAIN_CLASS="$MAIN_CLASS

if [ "$INSTANCEID" == "" ];then
  echo "error: INSTANCEID 不能为空!"
  exit 0
fi


__date=`date "+%Y-%m-%d %H:%M:%S"`
__pid=`ps -ef |grep "INSTANCEID=$INSTANCEID" |grep -v "grep" | awk '{print $2}'`
if [ "$__pid" == "" ];then
  echo "startup <$INSTANCEID> in $__date"
else
  read -p "$INSTANCEID 正在运行中pid=$__pid，是否重启[Y/N]？" __restart
  while true
  do
        case $__restart in
        Y | y)
              echo "kill -9 $__pid"
              kill -9 $__pid
              echo "关闭进程，重新启动..."
              echo "restart <$INSTANCEID> in $__date"
              break
              ;;
        N | n)
              ;;
        *)
             read -p "输入出错,请输入[Y/N]" __restart
             ;;
        esac
  done
fi

for file in ${BASE_HOME}/lib/*
do
    if test -f $file
    then
        echo $file 是文件
        if [ -n "${PRO_CLASSPATH}" ] ; then
		  PRO_CLASSPATH="$PRO_CLASSPATH:$file"
		else
		  PRO_CLASSPATH="$file"
		fi
    fi
done

if [ -n "${PRO_CLASSPATH}" ] ; then
  PRO_CLASSPATH="${BASE_HOME}/config/:${BASE_HOME}/web:$PRO_CLASSPATH"
else
  PRO_CLASSPATH="${BASE_HOME}/config/:${BASE_HOME}/web"
fi
echo "CLASSPATH="$PRO_CLASSPATH
echo $BASE_HOME"/bin/"$INSTANCEID".log"
$EXEC $JAVA_HOME/bin/java $JAVA_OPTS -DINSTANCEID=$INSTANCEID -DLOG_HOME=$LOG_HOME -cp "$PRO_CLASSPATH" "$MAIN_CLASS" >> $BASE_HOME"/bin/"$INSTANCEID".log" 2>&1 &
sleep 1
tail -0f $BASE_HOME"/bin/"$INSTANCEID".log"