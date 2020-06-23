package com.example.university.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeansConfig {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	@Bean
	public Module configureObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.;
	}
}
