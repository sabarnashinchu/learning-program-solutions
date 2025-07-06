package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insertEmployeesInBatch(int count) {
        for (int i = 1; i <= count; i++) {
            Employee emp = new Employee();
            emp.setName("Employee " + i);
            emp.setDepartment(i % 2 == 0 ? "IT" : "HR");

            entityManager.persist(emp);

            if (i % 20 == 0) { // batch_size
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
