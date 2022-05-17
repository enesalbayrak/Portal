package com.portal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMicroResponse {
    private String customerId;
    private String companyName;
    private String phone;
    private String email;
    private String sector;
    private String city;
    private String district;
    private String taxAdmistrationCity;
    private String taxAdmistrationName;
    private String taxNo;
}

