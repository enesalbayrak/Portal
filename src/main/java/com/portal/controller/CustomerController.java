package com.portal.controller;

import com.portal.dto.request.CustomerRequest;
import com.portal.dto.response.CustomerResponse;
import com.portal.entity.Customer;
import com.portal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.save(customerRequest);
    }
}
