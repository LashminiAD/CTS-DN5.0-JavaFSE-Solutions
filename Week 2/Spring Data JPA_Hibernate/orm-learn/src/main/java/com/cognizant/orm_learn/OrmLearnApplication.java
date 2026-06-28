package com.cognizant.orm_learn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {

        // Uncomment ONLY ONE method at a time

        // testSearchContaining();

        // testSearchContainingSorted();

         testStartsWith();	
	}

	// Query 1 - Search countries containing "ou"
	public void testSearchContaining() {
	System.out.println("\n===== Countries containing 'ou' =====");

        List<Country> countries = countryRepository.findByNameContaining("ou");

        countries.forEach(System.out::println);
}

    // Query 2 - Search countries containing "ou" in ascending order


public void testSearchContainingSorted() {
        System.out.println("\n===== Countries containing 'ou' (Sorted) =====");

    List<Country> countries =
        countryRepository.findByNameContainingOrderByNameAsc("ou");

    countries.forEach(System.out::println);

}
    // Query 3 - Search countries starting with "Z"

public void testStartsWith() {
		System.out.println("\n===== Countries starting with 'Z' =====");
    List<Country> countries =
        countryRepository.findByNameStartingWith("Z");

    countries.forEach(System.out::println);

}

}
