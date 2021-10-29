#!/bin/bash
docker stop postgres-codegen
docker image rm johnreah/postgres-codegen
cp ../accounts-netbeans/src/main/resources/accounts-netbeans.sql ./accounts-netbeans.sql
cp ../accounts-hibernate/src/main/resources/accounts-hibernate.sql ./accounts-hibernate.sql
docker build -t johnreah/postgres-codegen .
rm accounts-netbeans.sql
rm accounts-hibernate.sql
