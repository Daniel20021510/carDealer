package com.example.cardealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealerApplication {
//	@Bean
//	public ModelMapper modelMapper(){
//		ModelMapper modelMapper = new ModelMapper();
//
//		modelMapper.getConfiguration()
//				.setFieldMatchingEnabled(true)
//				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
//
//		return modelMapper;
//	}

	public static void main(String[] args) {
		SpringApplication.run(CarDealerApplication.class, args);
	}

}
