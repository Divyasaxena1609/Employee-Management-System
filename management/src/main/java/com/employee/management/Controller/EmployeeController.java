package com.employee.management.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.management.CustomResponse.ResponseApi;
import com.employee.management.Model.Employee;
import com.employee.management.Services.EmployeeService;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Add a new employee.
     */
    @PostMapping
    public ResponseEntity<ResponseApi<Employee>> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.saveEmployee(employee);
        ResponseApi<Employee> response = new ResponseApi<>("Employee created successfully", createdEmployee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Retrieve all employees.
     */
    @GetMapping
    public ResponseEntity<ResponseApi<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ResponseApi<List<Employee>> response = new ResponseApi<>("Employees retrieved successfully", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Retrieve a single employee by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseApi<Employee>> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            ResponseApi<Employee> response = new ResponseApi<>("Employee retrieved successfully", employee.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseApi<Employee> response = new ResponseApi<>("Employee not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an employee's details.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResponseApi<Employee>> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            ResponseApi<Employee> response = new ResponseApi<>("Employee updated successfully", updatedEmployee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ResponseApi<Employee> response = new ResponseApi<>("Failed to update employee", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete an employee by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseApi<Void>> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.deleteEmployee(id);
            ResponseApi<Void> response = new ResponseApi<>("Employee deleted successfully", null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            ResponseApi<Void> response = new ResponseApi<>("Employee not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Search employees by name or department.
     */
    @GetMapping("/search")
    public ResponseEntity<ResponseApi<List<Employee>>> searchEmployees(@RequestParam String query) {
        List<Employee> employees = employeeService.searchEmployees(query);
        ResponseApi<List<Employee>> response = new ResponseApi<>("Search completed successfully", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
