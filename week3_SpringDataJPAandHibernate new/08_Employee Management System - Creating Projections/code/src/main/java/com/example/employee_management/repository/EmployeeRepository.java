package com.example.employee_management.repository;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.dto.EmployeeDTO;
import com.example.employee_management.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Interface-based projection
    List<EmployeeNameEmailProjection> findByDepartmentId(Long deptId);

    // Class-based DTO projection
    @Query("SELECT new com.example.employee_management.dto.EmployeeDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeDTO> fetchEmployeeWithDeptName();
}
