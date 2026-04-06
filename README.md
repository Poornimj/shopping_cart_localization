# Shopping Cart Application with Database Localization

## Author

**Poornima Jayamanna**

---

## Project Description

This project is a **JavaFX-based Shopping Cart Application** that supports **multi-language localization using a database** and demonstrates modern software engineering and DevOps practices.

The application allows users to:

* Select a language
* Enter item count
* Input price and quantity
* Calculate total dynamically
* Store cart data in a database

---

## Features

### GUI Application

* Built using JavaFX
* Dynamic item entry
* Real-time total calculation

---

### Database Localization (Sprint 6)

* UI text is retrieved from a **MySQL database** instead of ResourceBundle
* Localization data stored in `localization_strings` table
* Supports multiple languages dynamically
* Easy to extend by adding new language rows

---

### Multi-Language Support

Supports 5 languages:

* English 🇬🇧
* Finnish 🇫🇮
* Swedish 🇸🇪
* Japanese 🇯🇵
* Arabic 🇸🇦 (Right-to-Left layout supported)

---

### Database Integration

The application stores cart data in MySQL:

#### Tables:

**cart_records**

* total_items
* total_cost
* language
* timestamp

**cart_items**

* item_number
* price
* quantity
* subtotal
* linked to cart_records via foreign key

---

### Testing

* JUnit 5 used for unit testing
* Business logic separated in `CartCalculator`
* JaCoCo used for code coverage

---

### DevOps Integration

* Docker for containerization
* Jenkins CI pipeline (Stage View)
* Kubernetes deployment

---

## Technologies Used

* Java 17
* JavaFX
* Maven
* MySQL
* JDBC
* JUnit 5
* JaCoCo
* Docker
* Jenkins
* Kubernetes

---

## Database Setup

Run the following SQL:

```sql
CREATE DATABASE shopping_cart_localization;

USE shopping_cart_localization;

CREATE TABLE cart_records (
    id INT AUTO_INCREMENT PRIMARY KEY,
    total_items INT,
    total_cost DOUBLE,
    language VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cart_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cart_record_id INT,
    item_number INT,
    price DOUBLE,
    quantity INT,
    subtotal DOUBLE,
    FOREIGN KEY (cart_record_id) REFERENCES cart_records(id)
);

CREATE TABLE localization_strings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `key` VARCHAR(100),
    value VARCHAR(255),
    language VARCHAR(10)
);
```

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

This is a **JavaFX desktop application**, so:

* GUI will not display inside Docker
* Docker is used for:

    * CI/CD pipeline
    * Packaging
    * Kubernetes deployment demonstration

---

## Jenkins Pipeline

The project includes a `Jenkinsfile` with stages:

* Checkout Source Code
* Build Project
* Run Tests
* Generate JaCoCo Report
* Build Docker Image
* Push Docker Image

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

Expected:

```
1/1 Running
```

---

## Project Structure

```
shopping-cart-app/
├── src/
│   └── shop/
│       ├── ShoppingCartApp.java
│       ├── ShoppingCartController.java
│       ├── CartCalculator.java
│       ├── CartService.java
│       ├── LocalizationService.java
│       └── DatabaseConnection.java
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
* Database tables (`cart_records`, `cart_items`)
* Jenkins pipeline
* Docker image
* Kubernetes pod running

---

## Final Status

✔ JavaFX GUI Working
✔ Database Localization Implemented
✔ Multi-language Support Working
✔ Cart Data Stored in Database
✔ Unit Tests Passing
✔ JaCoCo Coverage Generated
✔ Docker Image Built
✔ Jenkins Pipeline Successful
✔ Kubernetes Deployment Running

---

## Conclusion

This project demonstrates a complete **end-to-end software development workflow**, including:

* JavaFX UI development
* Database-driven localization
* Backend data persistence
* Unit testing and coverage
* CI/CD with Jenkins
* Containerization with Docker
* Kubernetes deployment

---
