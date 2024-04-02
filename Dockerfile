FROM maven:3-amazoncorretto-21 as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM amazoncorretto:21-alpine3.16-jdk
COPY --from=build /app/target/pet-care-backend-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]