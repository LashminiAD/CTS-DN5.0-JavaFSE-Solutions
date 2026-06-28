package com.cognizant.orm_learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Exercise 3
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // Exercise 4
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code)
            throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }

    // Exercise 5
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    // Update
    @PutMapping
    public Country updateCountry(@RequestBody Country country)
            throws CountryNotFoundException {
        return countryService.updateCountry(country);
    }

    // Delete
    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable String code)
            throws CountryNotFoundException {
        countryService.deleteCountry(code);
        return "Country Deleted Successfully";
    }
}