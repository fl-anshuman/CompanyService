package com.compny.companyService.controller;

import com.compny.companyService.dto.CompanyDTO;
import com.compny.companyService.models.Company;
import com.compny.companyService.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable int id) {
        CompanyDTO companyDTO = companyService.getCompanyById(id);
        return companyDTO != null ? ResponseEntity.ok(companyDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<String> updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
        return ResponseEntity.ok("Data updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Data deleted successfully");
    }
}
