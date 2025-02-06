package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class BricksCompanyApplication implements CommandLineRunner {

	@Autowired
	private DynamoDBService dynamoDBService;

	public static void main(String[] args) {
		SpringApplication.run(BricksCompanyApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Invoke the DynamoDB service
		dynamoDBService.printAllItems("BrickCompanies");
	}
}
