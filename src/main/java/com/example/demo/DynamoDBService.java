package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Map;

@Service
public class DynamoDBService {

    @Autowired
    private final DynamoDbClient dynamoDbClient;

    // Constructor for dependency injection
    public DynamoDBService(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    public void printAllItems(String tableName) {
        try {
            // Scan the table to retrieve all items
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse scanResponse = dynamoDbClient.scan(scanRequest);

            System.out.println("Items in table '" + tableName + "':");
            for (Map<String, AttributeValue> item : scanResponse.items()) {
                System.out.println("Item:");
                item.forEach((key, value) -> {
                    System.out.println("  - Attribute Name: " + key);
                    System.out.println("    Value: " + attributeValueToString(value));
                });
            }
        } catch (Exception e) {
            System.err.println("Failed to scan table '" + tableName + "'.");
            e.printStackTrace();
        }
    }

    // Utility method to convert AttributeValue to a readable string
    private String attributeValueToString(AttributeValue value) {
        if (value.s() != null) return value.s(); // String value
        if (value.n() != null) return value.n(); // Number value
        if (value.bool() != null) return String.valueOf(value.bool()); // Boolean value
        if (value.l() != null) return value.l().toString(); // List value
        if (value.m() != null) return value.m().toString(); // Map value
        if (value.b() != null) return value.b().asUtf8String(); // Binary value
        return "Unknown type";
    }

}
