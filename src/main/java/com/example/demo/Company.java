package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean // Required for Enhanced Client
public class Company {

    private String companyId;
    private String companyName;
    private List<String> brickTypes;
    private String imageUrl;
    private Map<String, Double> pricePerBrickType;
    private List<Integer> unitSizes;

    // Partition Key (Primary Key)
    @DynamoDbPartitionKey
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    // Sort Key (Secondary Key)
    @DynamoDbSortKey
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Attribute Mapping
    @DynamoDbAttribute("brickTypes")
    public List<String> getBrickTypes() {
        return brickTypes;
    }

    public void setBrickTypes(List<String> brickTypes) {
        this.brickTypes = brickTypes;
    }

    @DynamoDbAttribute("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @DynamoDbAttribute("pricePerBrickType")
    public Map<String, Double> getPricePerBrickType() {
        return pricePerBrickType;
    }

    public void setPricePerBrickType(Map<String, Double> pricePerBrickType) {
        this.pricePerBrickType = pricePerBrickType;
    }

    @DynamoDbAttribute("unitSizes")
    public List<Integer> getUnitSizes() {
        return unitSizes;
    }

    public void setUnitSizes(List<Integer> unitSizes) {
        this.unitSizes = unitSizes;
    }
}
