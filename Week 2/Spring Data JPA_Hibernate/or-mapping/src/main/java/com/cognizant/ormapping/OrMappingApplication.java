package com.cognizant.ormapping;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormapping.model.Department;
import com.cognizant.ormapping.model.Employee;
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

        // Create Department
        Department department = new Department();
        department.setName("Information Technology");
        department = departmentService.save(department);

        // Create Employee
        Employee employee = new Employee();
        employee.setName("Lashmini");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());

        // Many-to-One Mapping
        employee.setDepartment(department);

        employee = employeeService.save(employee);

        System.out.println("========== MANY TO ONE ==========");
        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }
}