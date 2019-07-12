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
