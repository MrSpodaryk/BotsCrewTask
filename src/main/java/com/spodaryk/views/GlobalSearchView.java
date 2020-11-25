package com.spodaryk.views;

import com.spodaryk.controllers.LectorController;
import com.spodaryk.models.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GlobalSearchView {

    @Autowired
    LectorController lectorController;

    public void showResultsOfGlobalSearch(String template) {

        List<Lector> allLectors = lectorController.getAllLectors();
        List<Lector> filteredLectors;

        String regex = ".*" + template + ".*";

        filteredLectors = allLectors.stream().filter(lector ->
                lector.getName().matches(regex) || lector.getSurname().matches(regex))
                .collect(Collectors.toList());

        if (filteredLectors.size() == 0) {
            System.out.println("There is no matches with \"" + template + "\" template\n");
        } else {
            System.out.println("What i found using \"" + template + "\" template:\n");
            for (Lector lector : filteredLectors) {
                System.out.println(lector.getName() + " " + lector.getSurname());
            }
            System.out.println();
        }
    }
}
