# REST API using Spring Boot

This is a simple REST API for managing team member details, implementing basic CRUD operations. It is built using **Spring Boot** and uses the **H2** in-memory database.

## Features

- **Create** a new employee
- **Read** employee details
- **Update** employee information
- **Delete** employee entries

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Java 17**

## Getting Started

### Prerequisites

- **Java 17** or higher installed on your system
- **Maven** installed (for building the project)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/darthchild/Spring-Boot-REST-API.git
   ```

2. Navigate into the project directory:
   ```bash
   cd Spring-Boot-REST-API-main
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

### Running the Application

1. After the build is complete, you can run the Spring Boot application using:
   ```bash
   mvn spring-boot:run
   ```

2. The API will be accessible at `http://localhost:8080`.

### H2 Database Console

You can access the H2 database console in the browser by navigating to `http://localhost:8080/h2-console`. Use the following credentials:

- **JDBC URL**: `jdbc:h2:file:./database`
- **Username**: `sa`
- **Password**: `password`

### Endpoints

- **POST** `/employees` - Add a new employee
- **GET** `/employees/all` - Retrieve a list of all employees
- **GET** `/employees/{id}` - Get details of a specific employee by ID
- **PUT** `/employees/{id}` - Update an employee's details
- **DELETE** `/employees/{id}` - Remove an employee from the database
