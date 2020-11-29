package com.spodaryk.DTO;

import com.spodaryk.models.Department;

public class StatisticResponse {

    private final Department department;
    private final int degreeId;
    private final Long degreesCount;

    public StatisticResponse(Department department, int degreeId, Long degreesCount) {
        this.department = department;
        this.degreeId = degreeId;
        this.degreesCount = degreesCount;
    }

    public Department getDepartment() {
        return department;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public Long getDegreesCount() {
        return degreesCount;
    }
}
