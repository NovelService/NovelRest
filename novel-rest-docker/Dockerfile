FROM openjdk:11-jre-slim

COPY ./target/novel-rest.jar ./novel-rest.jar

CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "./novel-rest.jar"]