package com.practice.ghas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.ghas.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}