package com.cognizant.springrest.controller;

import com.cognizant.springrest.model.Department;
import com.cognizant.springrest.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("START getAllDepartments");
        List<Department> list = departmentService.getAllDepartments();
        LOGGER.info("END getAllDepartments");
        return list;
    }
}
