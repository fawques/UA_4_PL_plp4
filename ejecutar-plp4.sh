#!/bin/bash
if test "$1" != ""; then
  java -classpath antlr-3.4-complete.jar:. plp4  $1
fi
