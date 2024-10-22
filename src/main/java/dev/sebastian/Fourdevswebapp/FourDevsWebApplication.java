package dev.sebastian.Fourdevswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EntityScan(value = "dev.sebastian.Fourdevswebapp")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class FourDevsWebApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(FourDevsWebApplication.class, args);
	}
}
