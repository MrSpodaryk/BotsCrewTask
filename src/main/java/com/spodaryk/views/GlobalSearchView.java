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

        List<String> filteredNameWithSurnameList;
        List<String> nameWithSurnameList;

        nameWithSurnameList = lectorController.getAllLectors().stream()
                .map(lector -> lector.getName() + " " + lector.getSurname())
                .collect(Collectors.toList());

        String regex = ".*" + template + ".*";

        filteredNameWithSurnameList = nameWithSurnameList.stream().filter(item ->
                item.matches(regex))
                .collect(Collectors.toList());

        if (filteredNameWithSurnameList.size() == 0) {
            System.out.println("There is no matches with \"" + template + "\" template\n");
        } else {
            System.out.println("What i found using \"" + template + "\" template:\n");
            filteredNameWithSurnameList.forEach(System.out::println);
            System.out.println();
        }
    }
}
