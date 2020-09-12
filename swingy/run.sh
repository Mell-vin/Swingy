#!/bin/bash

mvn clean
mvn compile
mvn package
java \target\swingy-0.0.1-SNAPSHOT.jar com.lgumede.swingy.Swingy.java
