package com.portal.service;

import com.portal.dto.request.EmployeeRequest;
import com.portal.dto.response.EmployeeResponse;
import com.portal.entity.Employee;

public interface EmployeeService {
    EmployeeResponse save(EmployeeRequest employeeRequest);
}
