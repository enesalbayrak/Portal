package com.portal.dto.response;

import com.portal.entity.Customer;
import com.portal.entity.Employee;
import com.portal.entity.Status;
import lombok.*;


@AllArgsConstructor
@ToString
@Data
@Getter
@Setter
public class ProjectManagerResponse {
    private long id;
    private String projectName;
    private EmployeeResponse employeeResponse;
}
