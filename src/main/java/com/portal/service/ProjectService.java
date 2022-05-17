package com.portal.service;

import com.portal.dto.request.AddProjectRequest;
import com.portal.dto.response.*;
import com.portal.entity.Project;

import java.util.List;

public interface ProjectService {
    AddProjectResponse save(AddProjectRequest request);

    ProjectManagerResponse addProjectManager(long projectId, long employeeId);

    List<Project> getProjects();

    ProjectTechLeadResponse addTechLead(long projectId, long employeeId);

    ProjectMemberResponse addMember(long projectId, long employeeId);

    List<ProjectResponse> getByCustomerName(String name);

    List<ProjectResponse> getByName(String name);

    List<CustomerMicroResponse> getAllCustomers();
    Object getCustomerById(String customerId);
    void printCustomerIdByKafka(String customerId);
}
