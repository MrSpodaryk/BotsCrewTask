package com.spodaryk.views;

import com.spodaryk.controllers.DepartmentController;
import com.spodaryk.exceptions.NoSuchElementInDBException;
import com.spodaryk.models.Department;
import com.spodaryk.models.Lector;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AverageSalaryView {

    @Autowired
    DepartmentController departmentController;

    public void showAverageSalaryOfDepartment(String key) {
        Department department;
        double totalSalary = 0;

        if (!FieldValidator.isValidate(key)) {
            return;
        }

        try {
            department = departmentController.getDepartmentById(Integer.parseInt(key));
        } catch (NoSuchElementInDBException e) {
            System.out.println("You entered wrong department id");
            return;
        }
        for (Lector lector : department.getLectors()) {
            totalSalary += lector.getSalary();
        }
        System.out.println("\nThe average salary of " + department.getName()
                + " department is $" + totalSalary / department.getLectors().size());

    }
}
