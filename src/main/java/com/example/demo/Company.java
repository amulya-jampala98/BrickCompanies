package com.example.demo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "BrickCompanies"  )
public class Company {

    @DynamoDBHashKey(attributeName = "companyId")
    private String companyId;

    @DynamoDBRangeKey(attributeName = "companyName")
    private String companyName;

    @DynamoDBAttribute(attributeName = "brickTypes")
    private List<String> brickTypes;

    @DynamoDBAttribute(attributeName = "imageUrl")
    private String imageUrl;

    @DynamoDBAttribute(attributeName = "pricePerBrickType")
    private Map<String, Double> pricePerBrickType;

    @DynamoDBAttribute(attributeName = "unitSizes")
    private List<Integer> unitSizes;

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<String> getBrickTypes() {
        return brickTypes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Map<String, Double> getPricePerBrickType() {
        return pricePerBrickType;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBrickTypes(List<String> brickTypes) {
        this.brickTypes = brickTypes;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPricePerBrickType(Map<String, Double> pricePerBrickType) {
        this.pricePerBrickType = pricePerBrickType;
    }

    public void setUnitSizes(List<Integer> unitSizes) {
        this.unitSizes = unitSizes;
    }

    public List<Integer> getUnitSizes() {
        return unitSizes;
    }
}
