#!/usr/bin/env bash

# Compilar
javac -d out src/main/java/*.java

# Ejecutar
java -cp out OMSTesting
