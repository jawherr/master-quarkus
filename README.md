# 🚀 Master Quarkus

![Repository Size](https://img.shields.io/github/repo-size/jawherr/master-quarkus)
![Last Commit](https://img.shields.io/github/last-commit/jawherr/master-quarkus)
![Issues](https://img.shields.io/github/issues/jawherr/master-quarkus)
![Stars](https://img.shields.io/github/stars/jawherr/master-quarkus)

A **professional, production‑ready Quarkus backend** built to **learn, practice, and master modern Java backend development**.
This repository focuses on **clean architecture**, **best practices**, and **real‑world patterns** used in scalable systems.

---

## ✨ Overview

**Master Quarkus** is a learning‑driven backend project that evolves step‑by‑step.
It starts with core Quarkus fundamentals and progressively adds:

* Layered architecture (Controller → Service → Repository)
* Pagination & sorting
* Clean error handling
* Database best practices
* API documentation
* Containerization & CI/CD

The goal is to serve as:

* 📚 A **personal knowledge base**
* 🧪 A **playground for backend experiments**
* 💼 A **portfolio‑ready backend project**

---

## 🏗️ Architecture

```
Client (REST / JSON)
        │
        ▼
Controller (JAX‑RS)
        │
        ▼
Service Layer (Business Logic)
        │
        ▼
Repository (Panache / Hibernate)
        │
        ▼
PostgreSQL Database
```

### Architectural Principles

* **Separation of Concerns**
* **Thin Controllers**
* **Business logic isolated in Services**
* **Repository pattern with Panache**
* **DTO‑friendly API design**

---

## 🚀 Features

### ✅ Implemented (v1)

* RESTful API with Quarkus (JAX‑RS)
* Clean Controller / Service / Repository separation
* PostgreSQL integration with Hibernate ORM + Panache
* Pagination with metadata:

  ```json
  {
    "data": [],
    "page": 0,
    "size": 10,
    "total": 42,
    "totalPages": 5,
    "links": {
        "next": null,
        "prev": null,
        "self": "/api/users?page=0&size=10"
    }
  }
  ```
* Sorting support (`sort=name,asc`)
* HATEOAS‑lite links (`self`, `next`, `prev`)
* Global exception handling
* OpenAPI & Swagger UI

### 🧭 Planned (Next Steps)

* DTO mapping & validation
* Authentication & Authorization (JWT)
* Role‑based access control (RBAC)
* Flyway database migrations
* Integration & unit testing
* Observability (metrics, health checks)
* Native image build

---

## 📁 Project Structure

```
master-quarkus/
├── src/main/java/com/example/
│   ├── controller/        # REST endpoints
│   ├── service/           # Business logic
│   ├── repository/        # Data access layer
│   ├── model/             # Entities & DTOs
│   ├── exception/         # Custom exceptions & mappers
│   ├── config/            # Application configuration
│   └── Application.java
│
├── src/main/resources/
│   ├── application.properties
│   └── db/                # Flyway migrations
│
├── src/test/java/          # Unit & integration tests
├── Dockerfile
├── pom.xml
└── README.md
```

---

## ⚙️ Technologies Used

| Category   | Tech                       |
| ---------- | -------------------------- |
| Framework  | **Quarkus**                |
| Language   | **Java 17**                |
| ORM        | Hibernate ORM + Panache    |
| API        | JAX‑RS (RESTEasy Reactive) |
| Database   | PostgreSQL                 |
| Build Tool | Maven                      |
| Docs       | OpenAPI / Swagger UI       |
| Container  | Docker                     |
| CI/CD      | GitHub Actions             |

---

## 🛠️ Getting Started

### Prerequisites

* Java **17+**
* Maven **3.8+**
* Docker (optional but recommended)

### Clone the Repository

```bash
git clone https://github.com/jawherr/master-quarkus.git
cd master-quarkus
```

### Run in Dev Mode

```bash
mvn quarkus:dev
```

### Build & Run (Production)

```bash
mvn clean package
java -jar target/quarkus-app/quarkus-run.jar
```

### Run with Docker

```bash
docker build -t master-quarkus .
docker run -p 8080:8080 master-quarkus
```

---

## 📘 API Documentation

* Swagger UI → **[http://localhost:8080/q/swagger-ui](http://localhost:8080/q/swagger-ui)**
* OpenAPI JSON → **[http://localhost:8080/q/openapi](http://localhost:8080/q/openapi)**

---

## 📡 Example Endpoints

### Get Users (Paginated)

```http
GET /api/users?page=0&size=10&sort=name,asc
```

### Create User

```http
POST /api/users
Content-Type: application/json
```

---

## 🧪 Testing

```bash
mvn test
```

```bash
mvn verify
```

---

## 📚 Learning Goals

This repository focuses on mastering:

* Quarkus internals & performance
* Clean backend architecture
* Database best practices
* Production‑ready REST APIs
* Modern Java ecosystem

---

## 🤝 Contributing

Contributions, ideas, and discussions are welcome!

1. Fork the repo
2. Create a feature branch
3. Commit your changes
4. Open a Pull Request

---

## 📜 License

This project is licensed under the **MIT License**.

---

## ⭐ Stargazers

If this project helps you, consider giving it a star 🌟
