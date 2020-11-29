package com.spodaryk.controllers;

import com.spodaryk.commands.Command;
import com.spodaryk.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ApplicationController {

    @Autowired
    DepartmentService service;

    @Autowired
    @Qualifier("globalSearchCommand")
    Command startGlobalSearchCommand;

    @Autowired
    @Qualifier("showAverageSalaryCommand")
    Command showAverageSalaryCommand;

    @Autowired
    @Qualifier("showHeadOfDepartmentCommand")
    Command showHeadOfDepartmentCommand;

    @Autowired
    @Qualifier("showNumberOfEmployeeCommand")
    Command showNumberOfEmployeeCommand;

    @Autowired
    @Qualifier("showStatisticCommand")
    Command showStatisticCommand;


    private final Scanner scanner = new Scanner(System.in);


    public void startGlobalSearch() {
        System.out.println("\nPlease enter the name OR surname OR another template without spaces");
        startGlobalSearchCommand.execute(scanner.nextLine());
    }

    public void showAverageSalary() {
        System.out.println("A -- Return to main menu");
        List<String> departmentName = service.getDepartmentsName();
        for (int i = 0; i < departmentName.size(); i++) {
            System.out.println((i + 1) + " -- Show The " + departmentName.get(i) + " Department average salary");
        }
        System.out.println("\nThe average salary of what department do you want to know?");
        showAverageSalaryCommand.execute(scanner.nextLine().toUpperCase());
    }

    public void showHeadOfDepartment() {
        System.out.println("A -- Return to main menu");
        List<String> departmentName = service.getDepartmentsName();
        for (int i = 0; i < departmentName.size(); i++) {
            System.out.println((i + 1) + " -- Show The Head of " + departmentName.get(i) + " Department");
        }
        System.out.println("\nThe head of what department do you want to know?");
        showHeadOfDepartmentCommand.execute(scanner.nextLine().toUpperCase());
    }

    public void showNumberOfEmployee() {
        System.out.println("A -- Return to main menu");
        List<String> departmentName = service.getDepartmentsName();
        for (int i = 0; i < departmentName.size(); i++) {
            System.out.println((i + 1) + " -- Show count of employee for " + departmentName.get(i) + " Department");
        }
        System.out.println("\nThe count of employee in what department do you want to know?");
        showNumberOfEmployeeCommand.execute(scanner.nextLine().toUpperCase());
    }

    public void showStatistic() {
        System.out.println("A -- Return to main menu");
        List<String> departmentName = service.getDepartmentsName();
        for (int i = 0; i < departmentName.size(); i++) {
            System.out.println((i + 1) + " -- Show The " + departmentName.get(i) + " Department statistics");
        }
        System.out.println("\nThe statistics of what department do you want to know?");
        showStatisticCommand.execute(scanner.nextLine().toUpperCase());
    }
}
