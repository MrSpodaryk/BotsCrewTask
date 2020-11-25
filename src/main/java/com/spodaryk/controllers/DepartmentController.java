package com.spodaryk.controllers;

import com.spodaryk.models.Department;
import com.spodaryk.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService service;

    public Department getDepartmentById(int id) {
        return service.getDepartmentById(id);
    }

    public List<String> getDepartmentsName() {
        return service.getDepartmentsName();
    }
}
