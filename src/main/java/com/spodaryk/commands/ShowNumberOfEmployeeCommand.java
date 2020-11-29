package com.spodaryk.commands;

import com.spodaryk.DTO.NumberOfEmployeeResponse;
import com.spodaryk.services.DepartmentService;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowNumberOfEmployeeCommand implements Command {

    @Autowired
    DepartmentService departmentService;

    @Override
    public void execute(String key) {
        NumberOfEmployeeResponse response;

        if (!FieldValidator.isValidate(key)) {
            return;
        }

        response = departmentService.getNumberOfEmployees(Integer.parseInt(key));

        if (response == null) {
            System.out.println("You entered wrong department id");
            return;
        }

        System.out.println("\nThe number of employee in " + response.getDepartment().getName() +
                " department is " + response.getNumberOfEmployee());
    }
}
