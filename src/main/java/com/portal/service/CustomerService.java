package com.portal.service;

import com.portal.dto.request.CustomerRequest;
import com.portal.dto.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse save(CustomerRequest customerRequest);
}
