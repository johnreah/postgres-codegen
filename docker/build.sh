#!/bin/bash
docker stop postgres-codegen
docker image rm johnreah/postgres-codegen
cp ../accounts-netbeans/src/main/resources/accounts-netbeans.sql ./accounts-netbeans.sql
cp ../accounts-hibernate/src/main/resources/accounts-hibernate.sql ./accounts-hibernate.sql
cp ../accounts-telosys-jpa/src/main/resources/accounts-telosys-jpa.sql ./accounts-telosys-jpa.sql
cp ../accounts-springdata-jpa/src/main/conf/accounts-springdata-jpa.sql ./accounts-springdata-jpa.sql
docker build -t johnreah/postgres-codegen .
rm accounts-netbeans.sql
rm accounts-hibernate.sql
rm accounts-telosys-jpa.sql
rm accounts-springdata-jpa.sql
