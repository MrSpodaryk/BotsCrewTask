package com.spodaryk.commands;

import com.spodaryk.DTO.StatisticResponse;
import com.spodaryk.services.DepartmentService;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ShowStatisticCommand implements Command {

    private static final int ASSISTANCE_ID = 1;
    private static final int ASSOCIATE_PROFESSOR_ID = 2;
    private static final int PROFESSOR_ID = 3;

    @Autowired
    DepartmentService departmentService;

    @Override
    public void execute(String key) {
        List<StatisticResponse> responses;

        if (!FieldValidator.isValidate(key)) {
            return;
        }

        responses = departmentService.getStatisticsOfDepartmentById(Integer.parseInt(key));

        if (responses.isEmpty()) {
            System.out.println("You entered wrong department id");
            return;
        }

        System.out.println("\n" + responses.get(0).getDepartment().getName() + " department statistics:\n");
        for (StatisticResponse response : responses) {
            switch (response.getDegreeId()) {
                case ASSISTANCE_ID:
                    System.out.println("assistants -- " + response.getDegreesCount());
                    break;
                case ASSOCIATE_PROFESSOR_ID:
                    System.out.println("associate professors -- " + response.getDegreesCount());
                    break;
                case PROFESSOR_ID:
                    System.out.println("professors -- " + response.getDegreesCount());
                    break;
            }
        }
    }
}
