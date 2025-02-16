package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class CompanyService {

    @Autowired
    public CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        System.out.println("Entered to Company Service Class");
        return companyRepository.findAll();
    }

}
