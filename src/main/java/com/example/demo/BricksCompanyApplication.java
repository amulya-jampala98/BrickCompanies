package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
