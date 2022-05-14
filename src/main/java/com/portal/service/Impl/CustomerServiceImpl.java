package com.portal.service.Impl;

import com.portal.dto.request.CustomerRequest;
import com.portal.dto.response.CustomerResponse;
import com.portal.entity.Customer;
import com.portal.repository.CustomerRepository;
import com.portal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        var customer = modelMapper.map(customerRequest, Customer.class);
        return modelMapper.map(customerRepository.save(customer),CustomerResponse.class);
    }
}
