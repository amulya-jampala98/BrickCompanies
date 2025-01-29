package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyService {


    @Autowired
     CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = (List<Company>) companyRepository.findAll();

        return companies.stream()
                .map(company -> new CompanyDTO(
                        company.getCompanyId(),
                        company.getCompanyName(),
                        company.getBrickTypes(),
                        company.getImageUrl(),
                        company.getPricePerBrickType(),
                        company.getUnitSizes()
                ))
                .collect(Collectors.toList());
    }
}
