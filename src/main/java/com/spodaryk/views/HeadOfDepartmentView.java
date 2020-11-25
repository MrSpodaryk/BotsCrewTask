package com.spodaryk.views;

import com.spodaryk.controllers.DepartmentController;
import com.spodaryk.controllers.LectorController;
import com.spodaryk.exceptions.NoSuchElementInDBException;
import com.spodaryk.models.Department;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentView {

    @Autowired
    LectorController lectorController;

    @Autowired
    DepartmentController departmentController;

    public void showHeadOfDepartment(String key) {
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

        String departmentName = department.getName();
        int headOfDepartmentId = department.getHeadOfDepartmentId();
        String lectorName = lectorController.getLectorById(headOfDepartmentId).getName();
        String lectorSurname = lectorController.getLectorById(headOfDepartmentId).getSurname();

        System.out.println("\nHead of " + departmentName + " department is " + lectorName + " " + lectorSurname);
    }
}
