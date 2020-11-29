package com.spodaryk.services;

import com.spodaryk.DTO.HeadOfDepartmentResponse;
import com.spodaryk.models.Lector;
import com.spodaryk.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    @Autowired
    LectorRepository repository;

    public List<Lector> findLectorsByTemplate(String template) {
        return repository.findLectorsByTemplate(template);
    }

    public HeadOfDepartmentResponse getHeadOfDepartmentByDepartmentId(int departmentId) {
        return repository.findHeadOfDepartmentByDepartmentId(departmentId);
    }
}
