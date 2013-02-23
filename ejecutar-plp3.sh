#!/bin/bash
if test "$1" != ""; then
  java -classpath antlr-3.4-complete.jar:. plp3  $1
fi
