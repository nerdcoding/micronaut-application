FROM openjdk:14-alpine
COPY target/micronaut-application-*.jar micronaut-application.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-application.jar"]