package com.example.demo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
@EnableScan // Required for scan operations in DynamoDB
public interface CompanyRepository extends CrudRepository<Company, String> {

}
