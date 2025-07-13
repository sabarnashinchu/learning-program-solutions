package com.example.demo.dao;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Skill;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    static {
        // ✅ Add a dummy employee so GET & PUT work without error
        try {
            Employee e = new Employee();
            e.setId(1L);
            e.setName("Dummy Employee");
            e.setSalary(10000.0);
            e.setPermanent(true);
            e.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"));

            Department d = new Department();
            d.setId(1L);
            d.setName("Dummy Dept");

            e.setDepartment(d);

            List<Skill> skills = new ArrayList<>();
            Skill s1 = new Skill();
            s1.setId(1L);
            s1.setName("Java");

            Skill s2 = new Skill();
            s2.setId(2L);
            s2.setName("Spring Boot");

            skills.add(s1);
            skills.add(s2);

            e.setSkills(skills);

            employeeList.add(e);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    // 🔷 Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // 🔷 Update employee if exists
    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(updatedEmployee.getId())) {
                employeeList.set(i, updatedEmployee);
                System.out.println("✅ Updated employee with id: " + updatedEmployee.getId());
                return;
            }
        }
        // if no employee found
        throw new EmployeeNotFoundException("Employee with id " + updatedEmployee.getId() + " not found");
    }
}
