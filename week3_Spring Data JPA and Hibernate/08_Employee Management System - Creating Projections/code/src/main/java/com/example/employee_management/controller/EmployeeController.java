package com.example.employee_management.controller;

import com.example.employee_management.dto.EmployeeDTO;
import com.example.employee_management.entity.Employee;
import com.example.employee_management.projection.EmployeeNameEmailProjection;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
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

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        if (emp.getDepartment() != null) {
            deptRepo.findById(emp.getDepartment().getId()).orElseThrow();
        }
        return empRepo.save(emp);
    }

    // Interface-based Projection
    @GetMapping("/projection/interface/{deptId}")
    public List<EmployeeNameEmailProjection> getEmployeeNamesEmailsByDept(@PathVariable Long deptId) {
        return empRepo.findByDepartmentId(deptId);
    }

    // Class-based Projection
    @GetMapping("/projection/class")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return empRepo.fetchEmployeeWithDeptName();
    }
}
