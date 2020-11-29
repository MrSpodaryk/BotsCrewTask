package com.spodaryk.commands;

import com.spodaryk.DTO.HeadOfDepartmentResponse;
import com.spodaryk.services.LectorService;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowHeadOfDepartmentCommand implements Command {

    @Autowired
    LectorService lectorService;

    @Override
    public void execute(String key) {
        HeadOfDepartmentResponse response;

        if (!FieldValidator.isValidate(key)) {
            return;
        }

        response = lectorService.getHeadOfDepartmentByDepartmentId(Integer.parseInt(key));

        if (response == null) {
            System.out.println("You entered wrong department id");
            return;
        }

        System.out.println("\nHead of " + response.getDepartment().getName() +
                " department is " + response.getLector().getName() +
                " " + response.getLector().getSurname());
    }
}
