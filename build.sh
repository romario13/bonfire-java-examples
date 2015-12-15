#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

mkdir -p $DIR/tests
javac $DIR/src/java/main/*.java -d $DIR/tests/

