package com.example.employee_management.repository;

import com.example.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query: find employees by department name
    List<Employee> findByDepartment_Name(String deptName);

    // Derived Query: find employees with name containing string (case-insensitive)
    List<Employee> findByNameContainingIgnoreCase(String name);

    // @Query: find employee by email
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    // @Query: find employees in department by deptName
    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> getEmployeesInDepartment(String deptName);

    // Named Query: find by departmentId
    @Query(name = "Employee.findByDepartmentId")
    List<Employee> findByDepartmentId(@Param("deptId") Long deptId);
}
