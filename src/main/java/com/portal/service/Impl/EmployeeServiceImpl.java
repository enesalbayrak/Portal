package com.portal.service.Impl;

import com.portal.dto.request.EmployeeRequest;
import com.portal.dto.response.EmployeeResponse;
import com.portal.entity.Employee;
import com.portal.repository.EmployeeRepository;
import com.portal.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        var employee = modelMapper.map(employeeRequest,Employee.class);
        return modelMapper.map(employeeRepository.save(employee),EmployeeResponse.class);
    }
}
