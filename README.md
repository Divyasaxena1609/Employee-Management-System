# Employee Management System

## Overview
The Employee Management System is a web-based application designed to manage employee data efficiently. It provides functionalities to add, update, delete, and view employee details. This system enables organizations to keep track of employee records, including personal details, job roles, and salary information.

## Features
- Employee Registration
- Update Employee Details
- Delete Employee Records
- View Employee List
- Search Employee by Name or ID
- RESTful API for CRUD Operations

## Technologies Used
### Backend:
- Java
- Spring Boot
- Spring Data JPA
- MySQL

### Frontend:
- HTML
- CSS
- JavaScript

### Tools & Platforms:
- IntelliJ IDEA / Eclipse
- Postman (for API testing)
- Git & GitHub
- Maven

### Ports
---

- Backend - localhost:8080

---

## API Endpoints
### Employee Management
| Method | Endpoint          | Description                 |
|--------|------------------|-----------------------------|
| GET    | /employees       | Get all employees           |
| GET    | /employees/{id}  | Get employee by ID         |
| POST   | /employees       | Add a new employee         |
| PUT    | /employees/{id}  | Update employee details    |
| DELETE | /employees/{id}  | Delete an employee         |

## Folder Structure
```
Employee-Management-System/
│── src/
│   ├── main/
│   │   ├── java/com/example/ems/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── EmployeeManagementSystemApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│── frontend/
│   ├── index.html
│   ├── styles.css
│   ├── script.js
│── pom.xml
│── README.md
```

## How to Run the Project
### Backend:
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/Employee-Management-System.git
   ```
2. Navigate to the backend directory and build the project:
   ```sh
   cd Employee-Management-System
   mvn clean install
   ```
3. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```
4. The backend will start at `http://localhost:8080`

### Frontend:
1. Open `index.html` in a browser.
2. Ensure the backend is running to fetch data properly.
