package com.spodaryk.repositories;

import com.spodaryk.DTO.HeadOfDepartmentResponse;
import com.spodaryk.models.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {

    @Query("SELECT l " +
            "FROM Lector l " +
            "WHERE l.name LIKE %?1% OR l.surname LIKE %?1%")
    List<Lector> findLectorsByTemplate(String template);


    @Query(value = "SELECT new com.spodaryk.DTO.HeadOfDepartmentResponse(d, l) " +
            "FROM Lector l " +
            "JOIN Department d ON d.headOfDepartmentId = l.id " +
            "WHERE d.id = ?1")
    HeadOfDepartmentResponse findHeadOfDepartmentByDepartmentId(int departmentId);
}
