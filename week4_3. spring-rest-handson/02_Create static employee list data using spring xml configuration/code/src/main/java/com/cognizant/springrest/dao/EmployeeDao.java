package com.cognizant.springrest.dao;

import com.cognizant.springrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    public static List<Employee> EMPLOYEE_LIST;

    @Autowired
    public EmployeeDao(ApplicationContext context) {
        // Load employee list from XML bean
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
