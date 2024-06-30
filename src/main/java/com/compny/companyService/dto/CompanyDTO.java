package com.compny.companyService.dto;

import com.compny.companyService.annotation.MaskedField;
import com.compny.companyService.annotation.MaskingStrategy;
import lombok.Data;


@Data
public class CompanyDTO {
    private int id;
    private String name;
    private String address;

    @MaskedField(strategy = MaskingStrategy.EMAIL)
    private String email;
    private double valuation;
}
