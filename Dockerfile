FROM gradle:9.4.1-jdk21-alpine

RUN mkdir /app

WORKDIR /app

COPY ./ ./

RUN gradle build -x test

VOLUME /tmp

EXPOSE 8080

ENV HTTP_PORT=8080

CMD ["java", "-jar", "build/libs/IpiCICD-0.0.1-SNAPSHOT.jar"]