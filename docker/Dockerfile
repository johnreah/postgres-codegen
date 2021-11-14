#============================================================================
# Dockerfile to build PostgreSQL instance for testing code generation options
#============================================================================

FROM	postgres

ENV	POSTGRES_PASSWORD=postgres

WORKDIR	/docker-entrypoint-initdb.d

COPY	accounts-netbeans.sql .
COPY	accounts-hibernate.sql .
COPY	accounts-telosys-jpa.sql .
COPY	accounts-springdata-jpa.sql .

RUN	echo "create database accounts_netbeans;" > database-init.sql && \
	echo "\\\c accounts_netbeans" >> database-init.sql && \
	cat accounts-netbeans.sql >> database-init.sql && \
	rm -f accounts-netbeans.sql && \
    echo "create database accounts_hibernate;" >> database-init.sql && \
    echo "\\\c accounts_hibernate" >> database-init.sql && \
    cat accounts-hibernate.sql >> database-init.sql  && \
    rm -f accounts-hibernate.sql && \
    echo "create database accounts_telosys_jpa;" >> database-init.sql && \
    echo "\\\c accounts_telosys_jpa" >> database-init.sql && \
    cat accounts-telosys-jpa.sql >> database-init.sql  && \
    rm -f accounts-telosys-jpa.sql && \
    echo "create database accounts_springdata_jpa;" >> database-init.sql && \
    echo "\\\c accounts_springdata_jpa" >> database-init.sql && \
    cat accounts-springdata-jpa.sql >> database-init.sql  && \
    rm -f accounts-springdata-jpa.sql
