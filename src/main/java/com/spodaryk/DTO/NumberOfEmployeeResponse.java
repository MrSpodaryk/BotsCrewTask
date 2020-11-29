package com.spodaryk.DTO;

import com.spodaryk.models.Department;

public class NumberOfEmployeeResponse {

    private final Department department;
    private final int numberOfEmployee;

    public NumberOfEmployeeResponse(Department department, int numberOfEmployee) {
        this.department = department;
        this.numberOfEmployee = numberOfEmployee;
    }

    public Department getDepartment() {
        return department;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }
}
