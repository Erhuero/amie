package com.mgen.amie.repository;

import com.mgen.amie.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    public boolean existsByFirstNameAndLastName(String firstName, String lastName);

    public boolean existsById(int id);

    @Query("" +
            "SELECT CASE WHEN COUNT(emp) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM EmployeeEntity emp " +
            "WHERE emp.firstName = ?1"
    )
    Boolean selectExistsName(String firstName);
}