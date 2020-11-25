package com.spodaryk.services;

import com.spodaryk.exceptions.NoSuchElementInDBException;
import com.spodaryk.models.Lector;
import com.spodaryk.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    @Autowired
    LectorRepository repository;

    public List<Lector> getAllLectors() {
        return repository.findAll();
    }

    public Lector getLectorById(int id) throws NoSuchElementInDBException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new NoSuchElementInDBException();
        }
    }
}
