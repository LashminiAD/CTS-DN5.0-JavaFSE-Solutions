package com.cognizant.springresthandson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springresthandson.model.Country;

@SpringBootApplication
public class SpringRestHandsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestHandsonApplication.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);

		System.out.println(country);
	}

}

