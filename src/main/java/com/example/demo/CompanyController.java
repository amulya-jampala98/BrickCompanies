package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/companies")

public class CompanyController {

    @Autowired
    public CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        System.out.print("Entered to Controller Class");
        return ResponseEntity.ok(companyService.getAllCompanies());

    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Company>> getCompanyById(@PathVariable String companyId){
//        List<Company> company = companyService.getCompanyById(companyId);
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @GetMapping("/{companyId}/{companyName}")
    public ResponseEntity<?> getCompanyByIdAndName(
            @PathVariable String companyId,
            @PathVariable String companyName) {

        try {
            Company company = companyService.getCompanyByIdAndName(companyId, companyName);
            return ResponseEntity.ok(company);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> saveCompany(@RequestBody Company company) {
        try {
            Company savedCompany = companyService.save(company);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCompany(@RequestBody Company updatedCompany) {
        try {
            Company updated = companyService.updateCompany(updatedCompany);
            return ResponseEntity.ok(updated);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
