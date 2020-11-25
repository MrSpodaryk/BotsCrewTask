package com.spodaryk.views;

import com.spodaryk.controllers.DepartmentController;
import com.spodaryk.exceptions.NoSuchElementInDBException;
import com.spodaryk.models.Department;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountOfEmployeeView {

    @Autowired
    DepartmentController departmentController;

    public void showNumberOfEmployeeInDepartment(String key) {
        Department department;

        if (!FieldValidator.isValidate(key)) {
            return;
        }

        try {
            department = departmentController.getDepartmentById(Integer.parseInt(key));
        } catch (NoSuchElementInDBException e) {
            System.out.println("You entered wrong department id");
            return;
        }

        System.out.println("\nThe number of employee in " + department.getName() +
                " department is " + department.getLectors().size());
    }
}
