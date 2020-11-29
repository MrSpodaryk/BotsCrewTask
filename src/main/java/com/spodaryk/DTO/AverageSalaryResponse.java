package com.spodaryk.DTO;

import com.spodaryk.models.Department;

public class AverageSalaryResponse {

    private final Department department;
    private final double averageSalary;

    public AverageSalaryResponse(Department department, double averageSalary) {
        this.department = department;
        this.averageSalary = averageSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public double getAverageSalary() {
        return averageSalary;
    }
}
