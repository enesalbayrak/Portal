package com.portal.dto.response;

import com.portal.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectMemberResponse {
    private long id;
    private String projectName;
    private List<Employee> projectMembers;
}
