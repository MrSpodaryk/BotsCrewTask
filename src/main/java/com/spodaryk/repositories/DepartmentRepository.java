package com.spodaryk.repositories;

import com.spodaryk.DTO.AverageSalaryResponse;
import com.spodaryk.DTO.NumberOfEmployeeResponse;
import com.spodaryk.DTO.StatisticResponse;
import com.spodaryk.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT new com.spodaryk.DTO.AverageSalaryResponse(d, AVG(l .salary)) " +
            "FROM Department d " +
            "INNER JOIN d.lectors l " +
            "WHERE d.id = ?1 " +
            "GROUP BY d.id")
    AverageSalaryResponse findAverageSalaryInDepartment(int departmentId);

    @Query("SELECT new com.spodaryk.DTO.NumberOfEmployeeResponse(d, size(d.lectors)) " +
            "FROM Department d " +
            "WHERE d.id = ?1")
    NumberOfEmployeeResponse findNumberOfEmployeesInDepartment(int departmentId);


    @Query("SELECT new com.spodaryk.DTO.StatisticResponse(d, l.degreeId, COUNT(l.degreeId)) " +
            "FROM Department d " +
            "INNER JOIN d.lectors l " +
            "WHERE d.id = ?1 " +
            "GROUP BY  l.degreeId")
    List<StatisticResponse> findStatisticsOfDepartmentById(int departmentId);

    @Query("SELECT d.name FROM Department d")
    List<String> findDepartmentsName();
}
