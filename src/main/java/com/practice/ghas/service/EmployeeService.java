package com.practice.ghas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.ghas.entity.Employee;
import com.practice.ghas.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return repository.findById(id).map(emp -> {
            emp.setFirstName(employeeDetails.getFirstName());
            emp.setLastName(employeeDetails.getLastName());
            emp.setEmail(employeeDetails.getEmail());
            return repository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}