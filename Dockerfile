FROM maven:3.8.5-openjdk-17 AS build
#WORKDIR /app
COPY . .
#RUN chmod +x ./mvnw
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/skylink.jar skylink.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/skylink.jar"]

#CMD ["java", "-jar", "target/skylink.jar"]