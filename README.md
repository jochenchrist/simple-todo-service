# simple-todo-service
A simple todo service that manages tasks using Spring Data Rest.

## Build
```
./gradlew clean build
docker build -t todo-service .
```

## Run
```
docker run -d --name mymongo mongo
docker run -d -p 8080:8080 --link mymongo:mongo --rm todo-service
```
