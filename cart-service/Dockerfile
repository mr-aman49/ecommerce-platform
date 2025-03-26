FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/cart-service-0.0.1-SNAPSHOT.jar cart-service.jar
ENTRYPOINT ["java", "-jar", "/cart-service.jar"]
