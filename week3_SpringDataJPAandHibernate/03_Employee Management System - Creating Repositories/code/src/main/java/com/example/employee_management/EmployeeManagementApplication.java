package com.example.employee_management;

import com.example.employee_management.entity.Department;
import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeRepository employeeRepo, DepartmentRepository deptRepo) {
        return args -> {
            Department it = new Department();
            it.setName("IT");
            deptRepo.save(it);

            Employee emp1 = new Employee();
            emp1.setName("John Doe");
            emp1.setEmail("john@example.com");
            emp1.setDepartment(it);
            employeeRepo.save(emp1);

            Employee emp2 = new Employee();
            emp2.setName("Jane Smith");
            emp2.setEmail("jane@example.com");
            emp2.setDepartment(it);
            employeeRepo.save(emp2);

            System.out.println("\nAll Employees:");
            employeeRepo.findAll().forEach(System.out::println);

            System.out.println("\nEmployee by Email:");
            System.out.println(employeeRepo.findByEmail("jane@example.com"));

            System.out.println("\nEmployees by Department Name:");
            employeeRepo.findByDepartment_Name("IT").forEach(System.out::println);
        };
    }
}
