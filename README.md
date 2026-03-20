# Java Shopping Cart Application

## Features
- Console-based shopping cart
- Localization: English, Finnish, Swedish, Japanese
- UTF-8 encoding
- Unit testing with JUnit 5
- Code coverage with JaCoCo
- CI/CD with Jenkins
- Dockerized application

## Run locally
mvn clean package
java -jar target/shopping-cart-app-1.0-SNAPSHOT.jar

## Run tests
mvn test
mvn jacoco:report

## Docker
docker build -t poornimj/shopping-cart-app:latest .
docker run -it poornimj/shopping-cart-app:latest