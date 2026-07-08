package com.cognizant.springresthandson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springresthandson.model.Country;

@RestController
public class CountryController {

    @Autowired
    private Country country;

    @GetMapping("/country")
    public Country getCountry() {
        return country;
    }
}