package com.spodaryk.commands;

import com.spodaryk.models.Lector;
import com.spodaryk.services.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalSearchCommand implements Command {

    @Autowired
    LectorService lectorService;

    @Override
    public void execute(String template) {
        List<Lector> lectors = lectorService.findLectorsByTemplate(template);

        if (lectors.size() == 0) {
            System.out.println("There is no matches with \"" + template + "\" template\n");
        } else {
            System.out.println("What i found using \"" + template + "\" template:\n");
            for (Lector lector : lectors) {
                System.out.println(lector.getName() + " " + lector.getSurname());
            }
            System.out.println();
        }
    }
}
