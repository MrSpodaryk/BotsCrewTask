package com.spodaryk.commands;

import com.spodaryk.DTO.AverageSalaryResponse;
import com.spodaryk.services.DepartmentService;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAverageSalaryCommand implements Command {

    @Autowired
    DepartmentService departmentService;

    @Override
    public void execute(String key) {
        AverageSalaryResponse response;

        if (!FieldValidator.isValidate(key)) {
            return;
        }

        response = departmentService.getAverageSalaryInDepartment(Integer.parseInt(key));

        if (response == null) {
            System.out.println("You entered wrong department id");
            return;
        }

        System.out.println("\nThe average salary of " + response.getDepartment().getName()
                + " department is $" + response.getAverageSalary());
    }
}
