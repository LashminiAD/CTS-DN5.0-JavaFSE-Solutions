package com.cognizant.ormapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormapping.model.Skill;
import com.cognizant.ormapping.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill get(int id) {
        return skillRepository.findById(id).orElse(null);
    }

    public void save(Skill skill) {
        skillRepository.save(skill);
    }
}