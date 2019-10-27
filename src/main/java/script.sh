#!/usr/bin/env bash
set -e
rm -f dynamic.jsa
time java -XX:ArchiveClassesAtExit=dynamic.jsa org/przybyl/ddj13/App.java
echo "AppCSD created."
echo
echo "Running without CSD."
time java -Xshare:off org/przybyl/ddj13/App.java
echo
echo "Running with JDK's CSD."
time java org/przybyl/ddj13/App.java
echo
echo "Running with AppCSD."
time java -XX:SharedArchiveFile=dynamic.jsa org/przybyl/ddj13/App.java