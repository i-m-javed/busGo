<div align="center">

# 🚌 busGo

A comprehensive, full-stack bus ticket booking system with distributed client-server architecture.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)

</div>

## Demo

<img src="assets/busGo.gif" width="100%">

## Overview

busGo is a robust, full-stack web application designed for comprehensive bus ticket booking and fleet management. Separated into a Spring Boot RESTful backend and a Thymeleaf-driven MVC frontend, the platform serves customers booking trips, drivers tracking upcoming routes, and administrators managing fleets, agencies, and offices.

## Highlights

* **Designed a Client-Server Architecture** separating the RESTful backend API from the Thymeleaf MVC frontend for optimal scalability.
* **Implemented secure JWT Authentication** and authorization to protect REST endpoints and manage stateful frontend sessions.
* **Engineered robust relational models** utilizing Spring Data JPA to manage complex relationships between Trips, Routes, Buses, and Drivers.
* **Developed interactive API views** inside the frontend using `RestTemplate` to dynamically consume and render robust backend resources.
* **Integrated centralized exception handling** using `@ControllerAdvice` to provide clean, standardized API error responses.

## Features

### Authentication & Authorization
* JWT-based secure login and token issuance.
* Role-protected dashboard and API routing.
* Frontend session invalidation and logout flows.

### Booking & Trip Management
* End-to-end ticket booking and payment processing.
* Real-time tracking of trip statuses and driver assignments.
* Route scheduling and bus-to-trip allocations.

### Administration & Operations
* Comprehensive management of travel agencies and local offices.
* Driver tracking, including upcoming trips and completed trip counts.
* Centralized dashboard for system-wide analytics and resource monitoring.

### User Experience
* Responsive Thymeleaf-based UI with dynamic routing.
* Seamless customer review system for trips and agencies.
* Dynamic view resolvers to render localized details for specific entities.

## Tech Stack

| Category | Technologies |
|---|---|
| **Backend** | Java 25, Spring Boot 4.0.4, Spring Data JPA, Spring Security, JWT (io.jsonwebtoken), Springdoc OpenAPI, Actuator |
| **Frontend** | Java 17, Spring Boot 4.0.5, Spring MVC, Thymeleaf, Spring Security |
| **Database** | MySQL |
| **Build Tool** | Maven |

## Architecture

The project utilizes a decoupled Client-Server Architecture built on the Spring Boot ecosystem. 
* **Backend:** Follows a classic Layered/N-Tier Architecture (Controllers, Services, Repositories, Entities, Mappers) to expose a stateless RESTful API.
* **Frontend:** Operates as an MVC web application consuming the backend API via `RestTemplate`, maintaining user sessions securely, and rendering views dynamically using Thymeleaf.

## Project Structure

```text
.
├── busGo-backend/
│   ├── src/main/java/com/busticket/
│   │   ├── controller/      # REST API Endpoints
│   │   ├── service/         # Business Logic
│   │   ├── respository/     # Data Access Layer
│   │   ├── entity/          # JPA Models
│   │   ├── mapper/          # DTO Mappers
│   │   └── security/        # JWT & Auth config
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── busGo-frontend/
│   ├── src/main/java/org/frontend/
│   │   ├── controller/      # MVC & Auth Controllers
│   │   └── config/          # App & Security Configurations
│   ├── src/main/resources/
│   │   ├── templates/       # Thymeleaf Views
│   │   └── static/          # CSS & JS assets
│   └── pom.xml
└── README.md
```

## Installation

Ensure you have Java (JDK 17+) and Maven installed.

1. Clone the repository.
2. Initialize the MySQL database named `busticketbooking`.
3. Update the database credentials in `busGo-backend/src/main/resources/application.properties` if necessary.

## Environment Variables

| Variable | Description |
|---|---|
| `spring.datasource.url` | JDBC connection URL for MySQL database |
| `spring.datasource.username` | Database username |
| `spring.datasource.password` | Database password |
| `jwt.secret` | Secret key used for signing JWT tokens |
| `jwt.expiration` | Expiration time for JWT tokens in milliseconds |
| `server.port` | Port on which the backend server runs (default: 8085) |

## Running Locally

To run the backend application:

```bash
cd busGo-backend
./mvnw clean install
./mvnw spring-boot:run
```

To run the frontend application:

```bash
cd busGo-frontend
./mvnw clean install
./mvnw spring-boot:run
```

## Available Scripts

Using the included Maven wrapper (`mvnw`), the following standard scripts are available:

* `./mvnw spring-boot:run` - Runs the application locally.
* `./mvnw clean install` - Cleans the target directory and compiles the application, running tests.
* `./mvnw test` - Executes the unit and integration test suite.

## Performance & Security

* **JWT Authentication:** Stateless token-based security for backend endpoints.
* **Session Management:** Secure HTTP sessions handling JWT storage in the frontend.
* **Database Indexing:** Handled natively through Spring Data JPA optimizations.
* **Centralized Error Handling:** Predictable and secure error exposure via GlobalExceptionHandler.

## Contributing

Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request for review. Ensure all new features are backed by appropriate test coverage.
