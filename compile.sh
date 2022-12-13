#!/bin/bash -ex

javac -d bin -cp phase2.jar src/cs1302/p2/BaseStringList.java
javac -cp bin:phase2.jar -d bin src/cs1302/p2/ArrayStringList.java
javac -cp bin:phase2.jar -d bin src/cs1302/p2/LinkedStringList.java
