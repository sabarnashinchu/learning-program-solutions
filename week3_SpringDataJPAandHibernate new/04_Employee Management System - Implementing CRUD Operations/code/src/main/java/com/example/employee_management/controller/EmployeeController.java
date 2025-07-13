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

    @GetMapping
    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return empRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        // Optional: make sure department exists
        if (emp.getDepartment() != null) {
            deptRepo.findById(emp.getDepartment().getId()).orElseThrow();
        }
        return empRepo.save(emp);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee updatedEmp) {
        Employee emp = empRepo.findById(id).orElseThrow();
        emp.setName(updatedEmp.getName());
        emp.setEmail(updatedEmp.getEmail());
        if (updatedEmp.getDepartment() != null) {
            deptRepo.findById(updatedEmp.getDepartment().getId()).orElseThrow();
            emp.setDepartment(updatedEmp.getDepartment());
        }
        return empRepo.save(emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        empRepo.deleteById(id);
    }
}
