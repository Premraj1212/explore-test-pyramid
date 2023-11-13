package com.premraj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class ShowroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowroomApplication.class, args);
	}

}
