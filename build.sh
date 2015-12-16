#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

mkdir -p $DIR/tests
javac $DIR/src/java/main/examples/*.java -d $DIR/tests/

