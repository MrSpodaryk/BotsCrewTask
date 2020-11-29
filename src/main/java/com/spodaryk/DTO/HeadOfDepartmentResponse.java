package com.spodaryk.DTO;

import com.spodaryk.models.Department;
import com.spodaryk.models.Lector;

public class HeadOfDepartmentResponse {

    private final Department department;
    private final Lector lector;

    public HeadOfDepartmentResponse(Department department, Lector lector) {
        this.department = department;
        this.lector = lector;
    }

    public Department getDepartment() {
        return department;
    }

    public Lector getLector() {
        return lector;
    }
}
