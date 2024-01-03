package com.example.springbootcrudapplication.repository;

import com.example.springbootcrudapplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
