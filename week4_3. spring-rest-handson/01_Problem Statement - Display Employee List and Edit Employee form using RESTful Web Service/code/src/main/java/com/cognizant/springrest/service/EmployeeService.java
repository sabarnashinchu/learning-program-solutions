package com.cognizant.springrest.service;

import com.cognizant.springrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private ApplicationContext context;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) context.getBean("employeeList");
    }
}
