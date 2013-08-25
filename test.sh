#!/bin/sh

while [ 1 ]
do
    inotifywait -e close_write `find src/ -type f`
    mvn clean test
done
