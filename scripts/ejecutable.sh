#!/bin/bash
cd /var/www/html/carpeta/springboot/
mvn package
cd target/
java -jar SpringBootCRUD-0.0.1-SNAPSHOT.jar
