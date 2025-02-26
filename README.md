# Employee-Management-System
Description
The Employee Management System is a web-based application that helps organizations to manage employee data efficiently. This application is built with a Spring Boot backend that serves a 
RESTful API for managing employee data. The frontend is built using HTML, CSS, and JavaScript, which allows users to interact with the system, create, update, delete, and search employees. 
The system also displays employee details in a dynamic table format and provides a form for adding or editing employee information.

Features
Add Employee: Create new employee records with details such as name, email, phone, and department.
Edit Employee: Edit details of existing employees.
Delete Employee: Remove an employee from the system.
Search Employees: Search employees by name or other attributes.
Employee List: A table that displays all employee data.
Validation: Form validation for input fields.

Tech Stack
Frontend: HTML, CSS, JavaScript (Vanilla)
Backend: Java, Spring Boot, Spring Data JPA
Database: MYSQL Database
API: RESTful API using Spring Boot
Other Tools: Axios for API calls, Maven for dependency management

Prerequisites
Before running the application, ensure you have the following software installed:

Java 11+: Install Java
Maven: Install Maven
Node.js: Install Node.js
Git: Install Git

Backend (Spring Boot)
Clone the repository:
git clone https://github.com/Divyasaxena1609/Employee-Management-System.git

Navigate to the backend directory:
cd Employee-Management-System/management

The Spring Boot application will be available at http://localhost:8080.

Frontend (JavaScript)
Navigate to the frontend directory
cd Employee-Management-System/frontend

Open the index.html file in your browser.
The Spring Boot application will be available at http://localhost:5500.

Usage
Once the backend is running, the frontend will interact with the REST API to manage employee data. The application allows the following:

Features
Add Employee: Fill out the form with employee details and click "Submit" to create a new employee.
Edit Employee: Click the "Edit" button beside an employee to modify their information.
Delete Employee: Click the "Delete" button beside an employee to remove them from the system.
Search Employee: Use the search bar to filter employees by their name or other attributes.
Employee List: A table that displays all employees, with their ID, name, email, phone, and department.
Frontend Interaction
Create Employee: Uses the POST /employees API to add a new employee.
Update Employee: Uses the PUT /employees/{id} API to update an existing employee.
Delete Employee: Uses the DELETE /employees/{id} API to delete an employee by ID.
Search Employees: Filters the employee list based on the search query.
API Endpoints
1. Get All Employees
Method: GET
Endpoint: /employees
Description: Retrieves a list of all employees.
2. Create Employee
Method: POST
Endpoint: /employees
Description: Creates a new employee. Requires employee details in the request body.
3. Get Employee by ID
Method: GET
Endpoint: /employees/{id}
Description: Fetches the details of an employee by ID.
4. Update Employee
Method: PUT
Endpoint: /employees/{id}
Description: Updates an existing employee's details. Requires employee data in the request body.
5. Delete Employee
Method: DELETE
Endpoint: /employees/{id}
Description: Deletes an employee by ID.
