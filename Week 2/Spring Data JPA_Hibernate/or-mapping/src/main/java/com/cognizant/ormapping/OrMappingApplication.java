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

    Skill java = new Skill();
    java.setName("Java");

    Skill spring = new Skill();
    spring.setName("Spring Boot");

    Employee employee = new Employee();
    employee.setName("Lashmini");
    employee.setSalary(50000);
    employee.setPermanent(true);
    employee.setDateOfBirth(new java.util.Date());

    java.util.Set<Skill> skills = new java.util.HashSet<>();
    skills.add(java);
    skills.add(spring);

    employee.setSkillList(skills);

    employeeService.save(employee);

    System.out.println("========== MANY TO MANY ==========");
    System.out.println(employee);
    System.out.println(employee.getSkillList());
}
}