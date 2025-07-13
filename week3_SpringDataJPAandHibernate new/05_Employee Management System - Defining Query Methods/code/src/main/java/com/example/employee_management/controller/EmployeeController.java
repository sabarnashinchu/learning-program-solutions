package com.example.employee_management.controller;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.repository.DepartmentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository empRepo;
    private final DepartmentRepository deptRepo;

    public EmployeeController(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
        this.empRepo = empRepo;
        this.deptRepo = deptRepo;
    }

    @GetMapping("/department/{name}")
    public List<Employee> getByDepartmentName(@PathVariable String name) {
        return empRepo.findByDepartment_Name(name);
    }

    @GetMapping("/name/{namePart}")
    public List<Employee> getByNameContaining(@PathVariable String namePart) {
        return empRepo.findByNameContainingIgnoreCase(namePart);
    }

    @GetMapping("/email/{email}")
    public Employee getByEmail(@PathVariable String email) {
        return empRepo.findByEmail(email);
    }

    @GetMapping("/namedquery/department/{id}")
    public List<Employee> getByDepartmentIdNamedQuery(@PathVariable Long id) {
        return empRepo.findByDepartmentId(id);
    }

    // existing CRUD endpoints…
}
