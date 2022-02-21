FROM maven:3-jdk-11-slim as build
LABEL maintainer="Jonas de Farias Peretiatko <jonasdefarias@hotmail.com>"

WORKDIR /app
COPY . .
RUN mvn -Dmaven.repo.local=/app/.m2/ install

FROM build as build-spring-boot

WORKDIR /app
COPY --from=build /app /app

RUN mvn -Dmaven.repo.local=/app/.m2/ install spring-boot:repackage -pl pg-application

FROM openjdk:11-jre-slim as deploy

WORKDIR /home/app/application

COPY --from=build-spring-boot /app/pg-application/target/pg-application-1.0-SNAPSHOT.jar /home/app/application

ARG postgres_host
ARG postgres_port
ARG postgres_db
ARG postgres_username
ARG postgres_password

ENV POSTGRES_HOST=$postgres_host
ENV POSTGRES_PORT=$postgres_port
ENV POSTGRES_DB=$postgres_db
ENV POSTGRES_USERNAME=$postgres_username
ENV POSTGRES_PASSWORD=$postgres_password

CMD ["java", "-Xms250m", "-Xmx512m", "-jar", "pg-application-1.0-SNAPSHOT.jar"]