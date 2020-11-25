package com.spodaryk.views;

import com.spodaryk.controllers.DepartmentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ApplicationView implements CommandLineRunner {

    private final Scanner scanner;
    private final Map<String, String> menu;

    @Autowired
    DepartmentController departmentController;

    @Autowired
    AverageSalaryView averageSalaryView;

    @Autowired
    CountOfEmployeeView countOfEmployeeView;

    @Autowired
    GlobalSearchView globalSearchView;

    @Autowired
    HeadOfDepartmentView headOfDepartmentView;

    @Autowired
    StatisticsView statisticsView;

    public ApplicationView() {
        scanner = new Scanner(System.in);
        menu = new LinkedHashMap<>();

        menu.put("A", "A -- Return to main menu");
        menu.put("1", "1 -- Show the heads of department");
        menu.put("2", "2 -- Show departments statistic");
        menu.put("3", "3 -- Show the average salary for the departments");
        menu.put("4", "4 -- Show the number of employee in departments");
        menu.put("5", "5 -- Global search");
        menu.put("Q", "Q -- Exit");
    }

    @Override
    public void run(String... args) {
        startConsoleProgram();
    }

    private void startConsoleProgram() {
        String inputKey;
        do {
            showMenu();
            inputKey = scanner.nextLine().toUpperCase();
            if (menu.containsKey(inputKey)) {
                showSubMenu(inputKey);
            } else {
                System.out.println("You typed wrong button");
            }
        } while (!inputKey.equals("Q"));
        System.exit(0);
    }

    private void showMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet()) {
            if (key.equals("A")) {
                continue;
            }
            System.out.println(menu.get(key));
        }
        System.out.println();
    }

    private void showSubMenu(String key) {
        List<String> departmentName = departmentController.getDepartmentsName();
        System.out.println("\n" + menu.get("A"));
        switch (key) {
            case "1":
                for (int i = 0; i < departmentName.size(); i++) {
                    System.out.println((i + 1) + " -- Show The Head of " + departmentName.get(i) + " Department");
                }
                System.out.println("\nThe head of what department do you want to know?");
                headOfDepartmentView.showHeadOfDepartment(scanner.nextLine().toUpperCase());
                break;
            case "2":
                for (int i = 0; i < departmentName.size(); i++) {
                    System.out.println((i + 1) + " -- Show The " + departmentName.get(i) + " Department statistics");
                }
                System.out.println("\nThe statistics of what department do you want to know?");
                statisticsView.showStatisticsOfDepartment(scanner.nextLine().toUpperCase());
                break;
            case "3":
                for (int i = 0; i < departmentName.size(); i++) {
                    System.out.println((i + 1) + " -- Show The " + departmentName.get(i) + " Department average salary");
                }
                System.out.println("\nThe average salary of what department do you want to know?");
                averageSalaryView.showAverageSalaryOfDepartment(scanner.nextLine().toUpperCase());
                break;
            case "4":
                for (int i = 0; i < departmentName.size(); i++) {
                    System.out.println((i + 1) + " -- Show count of employee for " + departmentName.get(i) + " Department");
                }
                System.out.println("\nThe count of employee in what department do you want to know?");
                countOfEmployeeView.showNumberOfEmployeeInDepartment(scanner.nextLine().toUpperCase());
                break;
            case "5":
                System.out.println("\nPlease enter the name OR surname OR another template without spaces inside");
                globalSearchView.showResultsOfGlobalSearch(scanner.nextLine());
                break;
        }
    }
}
