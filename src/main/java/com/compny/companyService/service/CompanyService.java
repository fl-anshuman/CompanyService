package com.compny.companyService.service;

import com.compny.companyService.dto.CompanyDTO;
import com.compny.companyService.models.Company;
import com.compny.companyService.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CompanyDTO getCompanyById(int id) {
        return companyRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(int id) {
        companyRepository.deleteById(id);
    }

    private CompanyDTO convertToDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setEmail(company.getEmail());
        companyDTO.setValuation(company.getValuation());
        return companyDTO;
    }
}
