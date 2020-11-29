package com.spodaryk.services;

import com.spodaryk.DTO.AverageSalaryResponse;
import com.spodaryk.DTO.NumberOfEmployeeResponse;
import com.spodaryk.DTO.StatisticResponse;
import com.spodaryk.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    public AverageSalaryResponse getAverageSalaryInDepartment(int departmentId) {
        return repository.findAverageSalaryInDepartment(departmentId);
    }

    public List<StatisticResponse> getStatisticsOfDepartmentById(int departmentId) {
        return repository.findStatisticsOfDepartmentById(departmentId);
    }

    public NumberOfEmployeeResponse getNumberOfEmployees(int departmentId) {
        return repository.findNumberOfEmployeesInDepartment(departmentId);
    }

    public List<String> getDepartmentsName() {
        return repository.findDepartmentsName();
    }
}
