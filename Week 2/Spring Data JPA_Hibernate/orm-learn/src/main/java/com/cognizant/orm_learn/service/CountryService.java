package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Get all countries
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Find country by code
    @Transactional(readOnly = true)
    public Country findCountryByCode(String code) throws CountryNotFoundException {

        return countryRepository.findById(code)
                .orElseThrow(() ->
                        new CountryNotFoundException("Country not found with code: " + code));
    }

    // Add new country
    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // Update existing country
    @Transactional
    public Country updateCountry(Country country) throws CountryNotFoundException {

        if (!countryRepository.existsById(country.getCode())) {
            throw new CountryNotFoundException("Country not found with code: " + country.getCode());
        }

        return countryRepository.save(country);
    }

    // Delete country
    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {

        if (!countryRepository.existsById(code)) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }

        countryRepository.deleteById(code);
    }
}