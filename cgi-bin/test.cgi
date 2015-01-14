#!/bin/sh
echo "Content-Type: text/plain"
echo ""
echo "This was a cgi-bin test: $0 $@"
date
pwd
env
type java
java -version

