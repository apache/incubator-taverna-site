#!/bin/sh
echo "Content-Type: text/plain"
echo ""
echo "This was a cgi-bin test: $0 $@"
date
pwd
env
type java
## Small memory footprint!
java -Xmx32M -jar scufl2-info-0.4.1-SNAPSHOT-standalone.jar 2>&1

