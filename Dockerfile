FROM oracle/graalvm-ce:20.2.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-application
WORKDIR /home/app/micronaut-application

RUN native-image -jar target/micronaut-application-*.jar micronaut-application

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-application/micronaut-application /app/micronaut-application
ENTRYPOINT ["/app/micronaut-application"]
