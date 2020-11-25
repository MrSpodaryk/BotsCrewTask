package com.spodaryk.views;

import com.spodaryk.controllers.DepartmentController;
import com.spodaryk.exceptions.NoSuchElementInDBException;
import com.spodaryk.models.Department;
import com.spodaryk.models.Lector;
import com.spodaryk.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsView {

    private static final int ASSISTANCE_ID = 1;
    private static final int ASSOCIATE_PROFESSOR_ID = 2;
    private static final int PROFESSOR_ID = 3;

    @Autowired
    DepartmentController departmentController;

    public void showStatisticsOfDepartment(String key) {
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

        int assistantsCount = 0;
        int associateProfessorsCount = 0;
        int professorsCount = 0;

        for (Lector lector : department.getLectors()) {
            if (lector.getDegreeId() == ASSISTANCE_ID) {
                assistantsCount++;
            } else if (lector.getDegreeId() == ASSOCIATE_PROFESSOR_ID) {
                associateProfessorsCount++;
            } else if (lector.getDegreeId() == PROFESSOR_ID) {
                professorsCount++;
            }
        }
        System.out.println("\n" +department.getName() + " department statistics: " +
                "\nassistants -- " + assistantsCount +
                "\nassociate professors -- " + associateProfessorsCount +
                "\nprofessors -- " + professorsCount);
    }
}
