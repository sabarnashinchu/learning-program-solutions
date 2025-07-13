package com.example.controller;
import com.example.primary.model.Employee;
import com.example.primary.repository.EmployeeRepository;
import com.example.secondary.model.AuditLog;
import com.example.secondary.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/names")
    public List<String> getEmployeeNames() {
        return employeeRepository.findAll()
                .stream()
                .map(Employee::getName)
                .toList();
    }

    @PostMapping("/log")
    public String saveLog(@RequestParam String action) {
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(log);
        return "Logged: " + action;
    }
}
