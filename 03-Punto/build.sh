#!/usr/bin/env bash

javac -d out src/main/java/*.java

java -cp out Main
