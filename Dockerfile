FROM openjdk:17-jre-slim
WORKDIR /app
COPY currency-app/target/currency-app-1.0-SNAPSHOT.jar /app/currency-converter.jar
CMD ["java", "-jar", "currency-converter.jar"]