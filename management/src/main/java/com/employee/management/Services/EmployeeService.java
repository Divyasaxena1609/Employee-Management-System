package com.employee.management.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.Model.Employee;
import com.employee.management.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Add a new employee.
     */
    public Employee saveEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Employee with this email already exists!");
        }
        return employeeRepository.save(employee);
    }

    /**
     * Retrieve all employees.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Retrieve a single employee by ID.
     */
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()) {
            throw new IllegalArgumentException("Employee with ID " + id + " does not exist!");
        }

        Employee existingEmployee = optionalEmployee.get();

        // Ensure email is unique when updating
        if (!existingEmployee.getEmail().equals(updatedEmployee.getEmail())
                && employeeRepository.existsByEmail(updatedEmployee.getEmail())) {
            throw new IllegalArgumentException("Another employee with this email already exists!");
        }

        // Update fields
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setPhone(updatedEmployee.getPhone());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }


    /**
     * Delete an employee by ID.
     */
    public void deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException("Employee with ID " + id + " does not exist!");
        }
        employeeRepository.deleteById(id);
    }

    /**
     * Search employees by name or department.
     */
    public List<Employee> searchEmployees(String query) {
        return employeeRepository.findByNameContainingOrDepartmentContaining(query, query);
    }
}
