package com.cognizant.ormapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormapping.model.Department;
import com.cognizant.ormapping.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department get(int id) {
        return departmentRepository.findById(id).orElse(null);
    }
    
}