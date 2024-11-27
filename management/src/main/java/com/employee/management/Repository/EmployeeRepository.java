package com.employee.management.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContainingOrDepartmentContaining(String name, String department);

    boolean existsByEmail(String email);

    Optional<Employee> findById(int id);

    
}


