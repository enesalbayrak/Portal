package com.portal.dto.response;

import com.portal.entity.Customer;
import com.portal.entity.Status;
import lombok.Data;

import java.util.Date;

@Data

public class AddProjectResponse {
    private String projectName;
    private Status status;
    private String offer;
    private Date startDate;
    private Date endDate;
    private Customer customer;
}
