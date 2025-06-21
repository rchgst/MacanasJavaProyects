#!/usr/bin/env bash

# Compilar
javac -d out src/main/java/*.java

cp -r src/main/resources out/

# Ejecutar
java -cp out Main
