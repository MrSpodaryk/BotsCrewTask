package com.spodaryk.views;

import com.spodaryk.controllers.ApplicationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApplicationView implements CommandLineRunner {

    private final Scanner scanner;
    private final Map<String, String> menu;

    @Autowired
    ApplicationController applicationController;

    public ApplicationView() {
        scanner = new Scanner(System.in);
        menu = new LinkedHashMap<>();

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
            System.out.println(menu.get(key));
        }
        System.out.println();
    }

    private void showSubMenu(String key) {
        switch (key) {
            case "1":
                applicationController.showHeadOfDepartment();
                break;
            case "2":
                applicationController.showStatistic();
                break;
            case "3":
                applicationController.showAverageSalary();
                break;
            case "4":
                applicationController.showNumberOfEmployee();
                break;
            case "5":
                applicationController.startGlobalSearch();
                break;
        }
    }
}
