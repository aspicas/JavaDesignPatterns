#!/bin/bash

#init
docker build -t javajdk:14 .
docker run -d --name javajdk javajdk:14
docker cp javajdk:/jdk/jdk.tar.gz jdk

#access to container
docker exec -t -i javajdk /bin/bash

#delete dangling images
docker rmi -f $(docker images -f "dangling=true" -q)

#delete containers stopped
docker rm $(docker ps -aq)

#delete containars running
docker rm -f $(docker ps -q)