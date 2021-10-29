#!/bin/bash
docker run \
	--name postgres-codegen \
	--rm \
	--env POSTGRES_PASSWORD=postgres \
	--publish 5432:5432 \
	johnreah/postgres-codegen
