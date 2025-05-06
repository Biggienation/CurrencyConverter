FROM openjdk:17-jdk-slim
WORKDIR /app
COPY runtime/currency-app-1.0-SNAPSHOT.jar /app/
COPY runtime/currency-converter1-1.0-SNAPSHOT.jar /app/
COPY runtime/currency-converter2-1.0-SNAPSHOT.jar /app/
COPY runtime/service-1.0-SNAPSHOT.jar /app/
CMD ["java", "--module-path", "./", "-m", "currency.app/com.java24.brix.currency.app.Main"]