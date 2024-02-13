<<<<<<< HEAD
# stage 1: build stage
FROM maven:3.8.4-openjdk-11 AS build
ENV CONFIGSTORECONNECTOR_CONTEXTPATH=/api/connector/configstore 
ENV CONFIGSTORECONNECTOR_HOST=http://localhost:8081/
ENV CREDITCARD_CONTEXTPATH=/
ENV CREDITCARD_HOST=http://localhost:8082
ENV ENCRYPTION_SECRET_KEY = 000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F
WORKDIR /app
RUN git clone https://github.com/surya-siddhi-sai-2710/Credit_Card.git
COPY . .
RUN mvn install

# Stage 2: Runtime Stage
FROM registry.access.redhat.com/ubi8/openjdk-11
WORKDIR /app
# Copy only necessary artifacts from the build stage
COPY --from=build /app/target/CreditCardAPI.jar .
# Set environment variables
ENV CONFIGSTORECONNECTOR_CONTEXTPATH=/api/connector/configstore 
ENV CONFIGSTORECONNECTOR_HOST=http://localhost:8081/
ENV CREDITCARD_CONTEXTPATH=/
ENV CREDITCARD_HOST=http://localhost:8082
ENV ENCRYPTION_SECRET_KEY = 000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F
# Expose
EXPOSE 8080
 
# command to run application
=======
# stage 1: build stage
FROM maven:3.8.4-openjdk-11 AS build
ENV CONFIGSTORECONNECTOR_CONTEXTPATH=/api/connector/configstore 
ENV CONFIGSTORECONNECTOR_HOST=http://localhost:8081/
ENV CREDITCARD_CONTEXTPATH=/
ENV CREDITCARD_HOST=http://localhost:8082
ENV ENCRYPTION_SECRET_KEY = 000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F
WORKDIR /app
RUN git clone https://github.com/surya-siddhi-sai-2710/Credit_Card.git
COPY . .
RUN mvn install

# Stage 2: Runtime Stage
FROM registry.access.redhat.com/ubi8/openjdk-11
WORKDIR /app
# Copy only necessary artifacts from the build stage
COPY --from=build /app/target/CreditCardAPI.jar .
# Set environment variables
ENV CONFIGSTORECONNECTOR_CONTEXTPATH=/api/connector/configstore 
ENV CONFIGSTORECONNECTOR_HOST=http://localhost:8081/
ENV CREDITCARD_CONTEXTPATH=/
ENV CREDITCARD_HOST=http://localhost:8082
ENV ENCRYPTION_SECRET_KEY = 000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F
# Expose
EXPOSE 8080
 
# command to run application
>>>>>>> 78a33deb80df9191b75f7896672f08786fb07b1f
CMD ["java", "-jar", "CreditCardAPI.jar"]