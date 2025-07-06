package com.example.employee_management.controller;

import com.example.employee_management.entity.Department;
import com.example.employee_management.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository deptRepo;

    public DepartmentController(DepartmentRepository deptRepo) {
        this.deptRepo = deptRepo;
    }

    @GetMapping
    public List<Department> getAll() {
        return deptRepo.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return deptRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Department create(@RequestBody Department dept) {
        return deptRepo.save(dept);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department updatedDept) {
        Department dept = deptRepo.findById(id).orElseThrow();
        dept.setName(updatedDept.getName());
        return deptRepo.save(dept);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deptRepo.deleteById(id);
    }
}
