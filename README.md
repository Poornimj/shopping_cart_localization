# Shopping Cart Application with Localization

## Author
**Poornima Jayamanna**

---

## Project Description
This project is a **JavaFX-based Shopping Cart Application** that supports **multiple languages** and demonstrates modern software engineering practices including:

- GUI development using JavaFX
- Internationalization (i18n)
- Unit testing with JUnit 5
- Code coverage using JaCoCo
- Containerization using Docker
- Continuous Integration with Jenkins
- Deployment using Kubernetes

---

## Features

### GUI Application
- Built using JavaFX
- Dynamic UI for entering items, prices, and quantities
- Calculates total cost

### Localization Support
Supports 5 languages:
- English 🇬🇧
- Finnish 🇫🇮
- Swedish 🇸🇪
- Japanese 🇯🇵
- Arabic 🇸🇦 (Right-to-Left support)

### Testing
- Unit tests implemented using **JUnit 5**
- Business logic separated in `CartCalculator`
- High code coverage using **JaCoCo**

### DevOps Features
- **Docker**: Application containerized
- **Jenkins**: CI pipeline with stages:
    - Checkout
    - Build
    - Test
    - JaCoCo Report
    - Docker Build
    - Docker Push
- **Kubernetes**: Deployment using YAML configuration

---

## Technologies Used

- Java 17
- JavaFX
- Maven
- JUnit 5
- JaCoCo
- Docker
- Jenkins
- Kubernetes

---

## How to Run the Application

### Run GUI locally:
```bash
mvn clean javafx:run