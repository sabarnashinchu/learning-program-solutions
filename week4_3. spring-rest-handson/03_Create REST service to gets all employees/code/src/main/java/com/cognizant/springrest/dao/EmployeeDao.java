package com.cognizant.springrest.dao;

import com.cognizant.springrest.model.Employee;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeDao {

    public static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
