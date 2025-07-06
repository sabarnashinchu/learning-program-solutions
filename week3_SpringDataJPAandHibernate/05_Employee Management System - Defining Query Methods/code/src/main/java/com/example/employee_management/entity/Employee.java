package com.example.employee_management.entity;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Employee.findByDepartmentId",
                query = "SELECT e FROM Employee e WHERE e.department.id = :deptId"
        ),
        @NamedQuery(
                name = "Employee.findAllOrderedByName",
                query = "SELECT e FROM Employee e ORDER BY e.name ASC"
        )
})
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters…
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
