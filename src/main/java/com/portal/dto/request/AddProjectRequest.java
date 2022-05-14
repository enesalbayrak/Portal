package com.portal.dto.request;

import com.portal.entity.Customer;
import com.portal.entity.Employee;
import com.portal.entity.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class AddProjectRequest {

    private String projectName;
    private Status status;
    private String offer;
    private Date startDate;
    private Date endDate;
    private CustomerRequest customerRequest;

}
