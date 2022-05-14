package com.portal.controller;

import com.portal.dto.request.EmployeeRequest;
import com.portal.dto.response.EmployeeResponse;
import com.portal.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.save(employeeRequest);
    }
}
