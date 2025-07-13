package com.cognizant.springrest.dao;

import com.cognizant.springrest.model.Department;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    public static List<Department> DEPARTMENT_LIST;

    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList", List.class);
        context.close();
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
