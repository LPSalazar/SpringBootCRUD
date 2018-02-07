#!/bin/bash
cd /home/ec2-user/pruebaDeErrorSpringBoot/SpringBootCRUD
mvn package
java -jar target/SpringBootCRUD-0.0.1-SNAPSHOT.jar
