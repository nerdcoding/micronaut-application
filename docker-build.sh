#!/bin/sh
docker build . -t nerdcoding/micronaut-application
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 nerdcoding/micronaut-application"