package com.dreamcricket.crickstat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;


@SpringBootApplication
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class CricStatApplication {

	public static void main(String[] args) {

		SpringApplication.run(CricStatApplication.class, args);
		System.out.println("Cricstat App Services");


	}


	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

}
