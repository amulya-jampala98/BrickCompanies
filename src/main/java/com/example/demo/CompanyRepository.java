package com.example.demo;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {

    private final DynamoDbTable<Company> companyTable;

    public CompanyRepository(DynamoDbEnhancedClient enhancedClient) {
        this.companyTable = enhancedClient.table("BrickCompanies",
                software.amazon.awssdk.enhanced.dynamodb.TableSchema.fromBean(Company.class));
    }

    // ✅ Save a Company (Insert or Update)
    public void save(Company company) {
        companyTable.putItem(company);
    }

    // ✅ Get a Company by ID
    public Optional<Company> findById(String companyId) {
        return Optional.ofNullable(companyTable.getItem(r -> r.key(k -> k.partitionValue(companyId))));
    }

    // ✅ Get All Companies (Scan)
    public List<Company> findAll() {
        return companyTable.scan(ScanEnhancedRequest.builder().build())
                .items()
                .stream()
                .collect(Collectors.toList());
    }

    // ✅ Delete a Company by ID
    public void deleteById(String companyId) {
        companyTable.deleteItem(r -> r.key(k -> k.partitionValue(companyId)));
    }
}
