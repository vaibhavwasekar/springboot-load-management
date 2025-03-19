# Liveasy Software Development Assignment

This project is developed using **Spring Boot** with **PostgreSQL** for database management. Below are the setup instructions, dependencies, and steps to run the application successfully.

---

## 📋 Project Overview
This project implements the required APIs as per the provided documentation. It covers CRUD operations with proper error handling and database integration.

---

## 🛠️ Prerequisites
Before running this project, ensure you have the following installed:

- **Java 17** or later  
- **PostgreSQL** (version 14 or later recommended)  
- **Maven** (for dependency management)  
- **Postman** (recommended for API testing)  

---

## 🗂️ Database Setup
1. **Install PostgreSQL:**  
   Download and install PostgreSQL from [here](https://www.postgresql.org/download/).

2. **Create a Database:**  
   - Open **pgAdmin** or use the PostgreSQL CLI.  
   - Run the following command to create the database:  
     ```sql
     CREATE DATABASE liveasy_db;
     ```

3. **Database Configuration:**  
   In the `application.properties` file, ensure the following configurations are set:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/liveasy_db
   spring.datasource.username=your_postgres_username
   spring.datasource.password=your_postgres_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
