# Master Quarkus

A professional Quarkus-based Java backend project to study and master modern backend development concepts with Quarkus.

---

## **Table of Contents**
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

---

## **Features**
- RESTful API implementation
- Dependency Injection with CDI
- Database integration with Hibernate ORM and Panache
- Exception handling and custom error responses
- Unit and integration testing
- Docker support for containerization
- CI/CD integration with GitHub Actions

---

## **Project Structure**
The project is organized as follows:
```
master-quarkus/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── config/                # Configuration classes
│   │   │           ├── controller/            # REST endpoints
│   │   │           ├── service/               # Business logic
│   │   │           ├── repository/            # Data access layer
│   │   │           ├── model/                 # Entity classes (e.g., JPA, DTOs)
│   │   │           ├── exception/             # Custom exceptions
│   │   │           ├── filter/                # Filters (e.g., JAX-RS filters)
│   │   │           ├── util/                  # Utility classes
│   │   │           └── Application.java       # Main application class
│   │   └── resources/
│   │       ├── application.properties         # Configuration properties
│   │       ├── META-INF/
│   │       │   └── resources/
│   │       │       └── index.html             # Optional: Static frontend
│   │       └── db/                            # Database migration scripts (e.g., Flyway)
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   ├── controller/            # Tests for REST endpoints
│                   ├── service/               # Tests for business logic
│                   └── repository/            # Tests for data access layer
├── .github/                                   # GitHub-specific files (e.g., workflows)
│   └── workflows/
│       └── ci.yml                             # CI/CD pipeline
├── .gitignore                                 # Git ignore rules
├── README.md                                  # Project documentation
├── pom.xml                                    # Maven build configuration
└── Dockerfile                                 # Docker configuration
```

---

## **Technologies Used**
- **Quarkus**: Supersonic Subatomic Java framework
- **Java**: Primary programming language
- **Maven**: Build automation tool
- **Hibernate ORM**: Object-relational mapping
- **RESTEasy**: JAX-RS implementation for RESTful APIs
- **Docker**: Containerization
- **GitHub Actions**: CI/CD pipeline
- **Flyway**: Database migrations

---

## **Getting Started**

### **Prerequisites**
- Java 17 or higher
- Maven 3.8.x or higher
- Docker (optional)

### **Installation**
1. Clone the repository:
   ```bash
   git clone https://github.com/jawherr/master-quarkus.git
   ```
2. Navigate to the project directory:
   ```bash
   cd master-quarkus
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```

### **Running the Application**
- Run the application in development mode:
  ```bash
  mvn quarkus:dev
  ```
- Run the application in production mode:
  ```bash
  mvn quarkus:build
  java -jar target/quarkus-app/quarkus-run.jar
  ```
- Run with Docker:
  ```bash
  docker build -t master-quarkus .
  docker run -p 8080:8080 master-quarkus
  ```

---

## **API Documentation**
- Swagger UI: [http://localhost:8080/q/swagger-ui](http://localhost:8080/q/swagger-ui)
- OpenAPI Schema: [http://localhost:8080/q/openapi](http://localhost:8080/q/openapi)

---

## **Testing**
- Run unit tests:
  ```bash
  mvn test
  ```
- Run integration tests:
  ```bash
  mvn verify
  ```

---

## **Contributing**
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

