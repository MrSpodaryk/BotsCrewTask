package com.spodaryk.controllers;

import com.spodaryk.models.Lector;
import com.spodaryk.services.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LectorController {

    @Autowired
    LectorService service;

    public List<Lector> getAllLectors() {
        return service.getAllLectors();
    }

    public Lector getLectorById(int id) {
        return service.getLectorById(id);
    }
}
