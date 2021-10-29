#!/bin/bash
docker stop postgres-codegen
docker image rm johnreah/postgres-codegen
cp ../accounts-netbeans/src/main/resources/accounts-netbeans.sql ./accounts-netbeans.sql
docker build -t johnreah/postgres-codegen .
rm accounts-netbeans.sql
