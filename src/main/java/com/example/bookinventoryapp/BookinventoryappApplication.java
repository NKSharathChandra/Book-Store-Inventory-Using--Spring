package com.example.bookinventoryapp;

import com.example.bookinventoryapp.config.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookinventoryappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookinventoryappApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new JWTFilter());
		filter.addUrlPatterns("/app/inventory/*");
		return filter;
	}

}
