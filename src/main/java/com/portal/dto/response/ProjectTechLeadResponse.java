package com.portal.dto.response;

import com.portal.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTechLeadResponse {
    private long id;
    private String projectName;
    private Employee projectTechLead;
}
