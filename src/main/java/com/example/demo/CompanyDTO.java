package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
public class CompanyDTO {

        private String companyId;
        private String companyName;
        private List<String> brickTypes;
        private String imageUrl;
        private Map<String, Double> pricePerBrickType;
        private List<Integer> unitSizes;

        public CompanyDTO(String companyId, String companyName, List<String> brickTypes, String imageUrl, Map<String, Double> pricePerBrickType, List<Integer> unitSizes) {
                this.companyId = companyId;
                this.companyName = companyName;
                this.brickTypes = brickTypes;
                this.imageUrl = imageUrl;
                this.pricePerBrickType = pricePerBrickType;
                this.unitSizes = unitSizes;
        }
}


