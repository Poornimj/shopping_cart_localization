# Shopping Cart Application with Localization

## Author

**Poornima Jayamanna**

---

## Project Description

This project is a **JavaFX-based Shopping Cart Application** that supports **multiple languages** and demonstrates modern software engineering and DevOps practices.

The application allows users to:

* Select a language
* Enter item count
* Input price and quantity
* Calculate total dynamically

---

## Features

### GUI Application

* Built using JavaFX
* Dynamic item entry
* Real-time total calculation

### Localization Support

Supports 5 languages:

* English 🇬🇧
* Finnish 🇫🇮
* Swedish 🇸🇪
* Japanese 🇯🇵
* Arabic 🇸🇦 (Right-to-Left layout supported)

### Testing

* JUnit 5 used for unit testing
* Business logic separated in `CartCalculator`
* JaCoCo used for code coverage

### DevOps Integration

* Docker for containerization
* Jenkins CI pipeline (Stage View)
* Kubernetes deployment

---

## Technologies Used

* Java 17
* JavaFX
* Maven
* JUnit 5
* JaCoCo
* Docker
* Jenkins
* Kubernetes

---

## How to Run the Application

### Run locally (GUI):

```bash
mvn clean javafx:run
```

---

## How to Run Tests

```bash
mvn clean test
```

### View Code Coverage Report:

Open:

```
target/site/jacoco/index.html
```

---

## Docker

### Build Docker Image:

```bash
docker build -t poornimj/shopping_cart_localization .
```

### Note:

This project is a **JavaFX desktop GUI application**.

* The Docker image is successfully built and used for CI/CD and Kubernetes deployment.
* However, the GUI cannot run inside a standard headless Docker container without additional JavaFX runtime and graphical environment configuration.

Therefore, Docker is used here primarily for:

* Packaging the application
* CI/CD pipeline integration
* Kubernetes deployment demonstration

---

## Jenkins Pipeline

The project includes a `Jenkinsfile` with the following stages:

* Checkout Source Code
* Build Project
* Run Tests
* Generate JaCoCo Report
* Build Docker Image
* Push Docker Image

Screenshot included in `screenshots/`

---

## Kubernetes Deployment

### Apply Deployment:

```bash
kubectl apply -f k8s-deployment.yaml
```

### Check Pods:

```bash
kubectl get pods
```

Expected output:

```
1/1 Running
```

Screenshot included in `screenshots/`

---

## Note on Kubernetes

Since this is a **JavaFX GUI application**:

* The graphical interface cannot be displayed inside Kubernetes
* The deployment demonstrates container orchestration and pod management

---

## Project Structure

```
shopping-cart-app/
├── src/
├── screenshots/
├── Dockerfile
├── Jenkinsfile
├── k8s-deployment.yaml
├── pom.xml
└── README.md
```

---

## Screenshots

The `screenshots/` folder includes:

* English UI
* Finnish UI
* Swedish UI
* Japanese UI
* Arabic UI (RTL)
* Jenkins Stage View
* Docker image
* Kubernetes pod running

---

## Final Status

✔ JavaFX GUI Working
✔ Localization Implemented
✔ Unit Tests Passing
✔ JaCoCo Coverage Generated
✔ Docker Image Built
✔ Jenkins Pipeline Successful
✔ Kubernetes Deployment Running

---

## Conclusion

This project demonstrates a complete **end-to-end software development workflow**, integrating:

* Frontend UI (JavaFX)
* Backend logic
* Testing
* CI/CD
* Containerization
* Kubernetes orchestration

---
