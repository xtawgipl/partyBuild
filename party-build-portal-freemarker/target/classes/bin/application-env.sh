#!/bin/bash

#工程唯一标识,用来标识pid
INSTANCEID="tydic-traffic-partybuild-portal"
#日志文件存放路径
LOG_HOME="/data/logs/$INSTANCEID"

#自定义JAVA_HOME
JAVA_HOME=$JAVA_HOME
#定义需要加入classpath的目录或文件,多个用 :分隔
PRO_CLASSPATH=web
#JAVA 参数
JAVA_OPTS="-Xms100m -Xmx200m"