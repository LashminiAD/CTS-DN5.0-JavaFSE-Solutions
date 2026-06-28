package com.cognizant.ormapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ormapping.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee")
    List<Employee> getAllEmployeesHQL();

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}