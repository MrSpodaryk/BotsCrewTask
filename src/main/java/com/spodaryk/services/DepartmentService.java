package com.spodaryk.services;

import com.spodaryk.exceptions.NoSuchElementInDBException;
import com.spodaryk.models.Department;
import com.spodaryk.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentById(int id) throws NoSuchElementException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new NoSuchElementInDBException();
        }
    }

    public List<String> getDepartmentsName() {
        return repository.findAll().stream()
                .map(Department::getName)
                .collect(Collectors.toList());
    }
}
