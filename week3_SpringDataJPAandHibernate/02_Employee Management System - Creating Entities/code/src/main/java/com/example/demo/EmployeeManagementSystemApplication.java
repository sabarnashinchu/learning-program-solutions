package com.example.demo;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmployeeManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(DepartmentRepository deptRepo) {
        return args -> {
            Department dept = new Department();
            dept.setName("IT");

            Employee emp1 = new Employee();
            emp1.setName("Alice");
            emp1.setEmail("alice@example.com");
            emp1.setDepartment(dept);

            Employee emp2 = new Employee();
            emp2.setName("Bob");
            emp2.setEmail("bob@example.com");
            emp2.setDepartment(dept);

            dept.setEmployees(List.of(emp1, emp2));

            deptRepo.save(dept);
        };
    }
}
