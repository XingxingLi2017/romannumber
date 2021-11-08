FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD romannumber-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]