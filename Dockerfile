FROM maven:4.0.0-jdk-17 as backend
COPY pom.xml /movieTime-Backend/
COPY mvnw /movieTime-Backend/
COPY .mvn /movieTime-Backend/.mvn
COPY src /movieTime-Backend/src/
WORKDIR /movieTime-Backend
RUN ./mvnw clean verify

FROM openjdk:17-jdk-alpine
COPY --from=backend /movieTime-Backend/target/movieTime-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
RUN adduser -D user
USER user
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]