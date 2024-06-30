package com.compny.companyService.models;

import com.compny.companyService.annotation.EncryptedField;
import com.compny.companyService.annotation.MaskedField;
import com.compny.companyService.annotation.MaskingStrategy;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Company {
    @Id
    private int id;
    private String name;
    private String address;

    @EncryptedField
//    @MaskedField(strategy = MaskingStrategy.EMAIL)/
    private String email;

    private double valuation;
}
