# microservice-java

## Guía para BD (PostgreSQL):

Hacer pull de postgres en docker:
```sh
docker pull postgres
```

Crear directorio
```sh
mkdir -p $HOME/docker/volumes/phman
```

Correr la imagen de Postgres
```sh
docker run --name phman_database -e POSTGRES_PASSWORD=admin -d -p 5432:5432 -v $HOME/docker/volumes/phman:/var/lib/postgresql/data postgres
```

Crear la tabla 
```sh
CREATE DATABASE phman
```

## Guía para el gestor de colas (Rabbit-MQ)

Hacer pull de rabbitmq, con el tag 3-management en docker:
```sh
docker pull rabbitmq:3-management
```

Crear directorio
```sh
mkdir -p $HOME/docker/volumes/rabbit
```


Correr la imagen de RabbitMQ
```sh
docker run -d --hostname rabbitmq --name brokermq -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=phman -e RABBITMQ_DEFAULT_PASS=phman# -v $HOME/docker/volumes/rabbit:/var/lib/rabbitmq rabbitmq:3-management 
```


## MS Property-Service

Crear e Usuario de la base de datos
```sh
CREATE USER property WITH PASSWORD 'property#' NOSUPERUSER NOCREATEDB NOCREATEROLE;
```
Agregar permisos de super user
```sh
ALTER ROLE property SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN;
```

Creacion del esquema
```sh
CREATE SCHEMA IF NOT EXISTS property AUTHORIZATION property;
```

Asignar Permisos:
```sh
ALTER DEFAULT PRIVILEGES IN SCHEMA property GRANT SELECT ON TABLES TO property;


ALTER DEFAULT PRIVILEGES IN SCHEMA property GRANT UPDATE ON TABLES TO property;


ALTER DEFAULT PRIVILEGES IN SCHEMA property GRANT INSERT ON TABLES TO property;


ALTER DEFAULT PRIVILEGES IN SCHEMA property GRANT DELETE ON TABLES TO property;
```

## MS Person-Service

Crear e Usuario de la base de datos
```sh
CREATE USER person WITH PASSWORD 'person#' NOSUPERUSER NOCREATEDB NOCREATEROLE;
```
Agregar permisos de super user
```sh
ALTER ROLE person SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN;
```

Creacion del esquema
```sh
CREATE SCHEMA IF NOT EXISTS person AUTHORIZATION person;
```

Asignar Permisos:
```sh
ALTER DEFAULT PRIVILEGES IN SCHEMA person GRANT SELECT ON TABLES TO person;


ALTER DEFAULT PRIVILEGES IN SCHEMA person GRANT UPDATE ON TABLES TO person;


ALTER DEFAULT PRIVILEGES IN SCHEMA person GRANT INSERT ON TABLES TO person;


ALTER DEFAULT PRIVILEGES IN SCHEMA person GRANT DELETE ON TABLES TO person;
```
