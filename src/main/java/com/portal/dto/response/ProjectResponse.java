package com.portal.dto.response;

import com.portal.entity.Customer;
import com.portal.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class ProjectResponse {
    private String projectName;
    private String customerName;
}
