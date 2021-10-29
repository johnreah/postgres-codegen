#============================================================================
# Dockerfile to build PostgreSQL instance for testing code generation options
#============================================================================

FROM	postgres

ENV	POSTGRES_PASSWORD=postgres

WORKDIR	/docker-entrypoint-initdb.d

COPY	accounts-netbeans.sql .
COPY	accounts-hibernate.sql .

RUN	echo "create database accounts_netbeans;" > database-init.sql && \
	echo "\\\c accounts_netbeans" >> database-init.sql && \
	cat accounts-netbeans.sql >> database-init.sql && \
	rm -f accounts-netbeans.sql && \

    echo "create database accounts_hibernate;" >> database-init.sql && \
    echo "\\\c accounts_hibernate" >> database-init.sql && \
    cat accounts-hibernate.sql >> database-init.sql  && \
    rm -f accounts-hibernate.sql
