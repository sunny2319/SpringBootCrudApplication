package com.example.springbootcrudapplication.controller;

import com.example.springbootcrudapplication.exception.ResourceNotFoundException;
import com.example.springbootcrudapplication.model.Employee;
import com.example.springbootcrudapplication.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    IEmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
       return employeeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
       Employee createdEmployee = employeeRepository.save(employee);
       return ResponseEntity.ok(createdEmployee);
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id = " + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeByid(@PathVariable long id, @RequestBody Employee employee)
    {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id = " + id));
        employee1.setfName(employee.getfName());
        employee1.setlName(employee.getlName());
        employee1.setEmailId(employee.getEmailId());
        employeeRepository.save(employee1);
        return ResponseEntity.ok(employee1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployeeByid(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id = "+ id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok(employee);
    }
}
