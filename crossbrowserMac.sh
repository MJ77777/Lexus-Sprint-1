#!/bin/sh
mvn test -D xmlFile=smoke-test.xml -D browser=chrome
mvn test -D xmlFile=smoke-test.xml -D browser=edge
mvn test -D xmlFile=smoke-test.xml -D browser=firefox