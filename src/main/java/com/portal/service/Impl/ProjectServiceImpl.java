package com.portal.service.Impl;

import com.portal.dto.request.AddProjectRequest;
import com.portal.dto.response.*;
import com.portal.entity.Customer;
import com.portal.entity.Employee;
import com.portal.entity.Project;
import com.portal.repository.EmployeeRepository;
import com.portal.repository.ProjectRepository;
import com.portal.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    @Override
    public AddProjectResponse save(AddProjectRequest request) {
        var project = modelMapper.map(request, Project.class);
        return modelMapper.map(projectRepository.save(project),AddProjectResponse.class);
    }

    @Override
    public ProjectManagerResponse addProjectManager(long projectId, long employeeId) {
        var project = projectRepository.findById(projectId).orElseThrow(()->new NoSuchElementException("Proje bulunamadı"));
        var employee = employeeRepository.findById(employeeId).orElseThrow(()->new NoSuchElementException("Employee bulunamadı"));
        project.setProjectManager(employee);

        var savedProject= projectRepository.save(project);
        var response = new ProjectManagerResponse(projectId,savedProject.getProjectName(),new EmployeeResponse(project.getProjectManager().getFullname(),project.getProjectManager().getMail(),project.getProjectManager().getPhone()));
        return response;
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectTechLeadResponse addTechLead(long projectId, long employeeId) {
        var project = projectRepository.findById(projectId).orElseThrow(()->new NoSuchElementException("Proje bulunamadı"));
        var employee = employeeRepository.findById(employeeId).orElseThrow(()->new NoSuchElementException("Employee bulunamadı"));
        project.setProjectTechLead(employee);
        var savedProject = projectRepository.save(project);
        return new ProjectTechLeadResponse(projectId,savedProject.getProjectName(),savedProject.getProjectTechLead());


    }

    @Override
    public ProjectMemberResponse addMember(long projectId, long employeeId) {
        var project = projectRepository.findById(projectId).orElseThrow(()->new NoSuchElementException("Proje bulunamadı"));
        var employee = employeeRepository.findById(employeeId).orElseThrow(()->new NoSuchElementException("Employee bulunamadı"));
        project.getProjectMembers().add(employee); //???
        var savedProject = projectRepository.save(project);
        return new ProjectMemberResponse(savedProject.getId(),savedProject.getProjectName(),savedProject.getProjectMembers());
    }

    @Override
    public List<ProjectResponse> getByCustomerName(String name) {
        return projectRepository.getAllByCustomerFullname(name)
                .stream()
                .map(project->new ProjectResponse(project.getProjectName(), name)).toList();
    }

    @Override
    public List<ProjectResponse> getByName(String name) {
        return  projectRepository.getAllByProjectName(name).stream().map(project->new ProjectResponse(project.getProjectName(), project.getCustomer().getFullname())).toList();
    }

    @Override
    public List<CustomerMicroResponse> getAllCustomers() {
        var getAllCustomersUrl ="http://localhost:2001/customer/api/v1/customers/";
        var customerMicroResponses = restTemplate.getForEntity(getAllCustomersUrl,CustomerMicroResponse[].class).getBody();
        return Arrays.asList(customerMicroResponses);
    }

    @Override
    public CustomerMicroResponse getCustomerById(String customerId) {
        var getCustomerIdUrl = "http://localhost:2001/customer/api/v1/customers/"+customerId;
        var customerMicroResponses = restTemplate.getForEntity(getCustomerIdUrl,CustomerMicroResponse.class).getBody();
        return customerMicroResponses;
    }

    @KafkaListener(topics = "customerId",groupId = "projectGroup")
    @Override
    public void printCustomerIdByKafka(String customerId) {
        System.err.println(customerId+" is deleted");

    }

}
