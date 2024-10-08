package dev.sebastian.housinginsecurityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class HousingInsecurityAppApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(HousingInsecurityAppApplication.class, args);
	}

}
