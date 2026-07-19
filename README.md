# Online Shopping Platform — E-Commerce

Free Java Full Stack Internship Task — **JV-EC-001** | Data Alcott Systems
Student Code: **DAS-JV-001**

Task link: https://www.freeinternships.in/java-full-stack-internship/free-java-full-stack-internship-online-ecommerce-shopping-platform-jv-ec-001.php

## Overview

A full-stack e-commerce shopping platform built with Spring Boot, Spring Security, Hibernate/JPA, MySQL and Thymeleaf. Users can browse products, search/filter by category, manage a shopping cart, place orders and view order history. Admins can manage products and update order statuses from an admin dashboard.

## Tech Stack

- Java 17
- Spring Boot 3.2
- Spring Security (form login, role-based access)
- Spring Data JPA / Hibernate
- MySQL
- Thymeleaf + Bootstrap 5
- Maven
- Lombok

## Features

- User registration & login (BCrypt password hashing)
- Role-based access control (USER / ADMIN)
- Product catalog with category filter and keyword search + pagination
- Shopping cart (add / update quantity / remove)
- Checkout with shipping address, simulated payment step
- Order placement, stock deduction, order history, order detail view
- Admin dashboard: product CRUD, order list with status updates

## Database Schema

See `src/main/resources/data.sql` for sample data. Tables (auto-created by Hibernate on first run): `users`, `categories`, `products`, `cart_items`, `orders`, `order_items`.

## Setup Instructions

### Prerequisites
- JDK 17+
- Maven 3.6+ (or use the bundled `mvnw`)
- MySQL 8 running locally

### 1. Configure the database
Edit `src/main/resources/application.properties` if your MySQL username/password differ from the defaults:
```properties
spring.datasource.username=root
spring.datasource.password=ajith
```
The database `ecommerce_db` is created automatically on first run (`createDatabaseIfNotExist=true`) — no manual `CREATE DATABASE` step needed.

### 2. Run the application
From the project root:
```bash
./mvnw spring-boot:run
```
Or import into Spring Tool Suite 4 as an existing Maven project and run `EcommerceApplication.java` as a **Spring Boot App**.

The app starts on **http://localhost:8085**

### 3. Sample login credentials
| Role  | Email                | Password  |
|-------|-----------------------|-----------|
| Admin | admin@shopease.com    | admin123  |
| User  | Register your own via `/register` |

### 4. Export the database (for submission)
Once the app has run at least once (tables created + sample data loaded):
```bash
mysqldump -u root -p ecommerce_db > ecommerce_db.sql
```

## Project Structure

```
src/main/java/com/ecommerce/
├── EcommerceApplication.java
├── config/          # Spring Security & Web config
├── controller/      # MVC controllers
├── model/           # JPA entities
├── repository/      # Spring Data repositories
├── service/         # Business logic
src/main/resources/
├── templates/        # Thymeleaf views
├── static/css/       # Stylesheets
├── application.properties
└── data.sql          # Sample categories, products, admin user
```

## Learning Outcomes

- Building a layered Spring Boot MVC application (Controller → Service → Repository → Entity)
- Implementing authentication & role-based authorization with Spring Security
- Modeling relational data with JPA/Hibernate (one-to-many, many-to-one)
- Server-side rendering with Thymeleaf and Spring Security's Thymeleaf extras
- Transactional order processing (cart → order → stock deduction)

## Author

Submitted as part of the Free Java Full Stack Internship Online — Data Alcott Systems.
