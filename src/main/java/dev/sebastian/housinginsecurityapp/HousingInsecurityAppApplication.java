package dev.sebastian.housinginsecurityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EntityScan(value = "dev.sebastian.housinginsecurityapp.model")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class HousingInsecurityAppApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(HousingInsecurityAppApplication.class, args);
	}

}
