package com.cognizant.ormapping;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormapping.model.Department;
import com.cognizant.ormapping.model.Employee;
import com.cognizant.ormapping.model.Skill;
import com.cognizant.ormapping.service.DepartmentService;
import com.cognizant.ormapping.service.EmployeeService;

@SpringBootApplication
public class OrMappingApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(OrMappingApplication.class, args);
    }
@Override
public void run(String... args) throws Exception {

    System.out.println("========== HQL QUERY ==========");
    employeeService.getAllEmployeesHQL()
            .forEach(System.out::println);

    System.out.println();

    System.out.println("========== NATIVE QUERY ==========");
    employeeService.getAllEmployeesNative()
            .forEach(System.out::println);
}


}