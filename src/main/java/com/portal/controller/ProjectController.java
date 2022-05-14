package com.portal.controller;

import com.portal.dto.request.AddProjectRequest;
import com.portal.dto.response.*;
import com.portal.entity.Project;
import com.portal.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public AddProjectResponse addProject(@RequestBody AddProjectRequest request){
        return projectService.save(request);
    }
    @PostMapping("/addManager")
    public ProjectManagerResponse addProjectManager(@RequestParam long projectId, @RequestParam long employeeId){
        return projectService.addProjectManager(projectId,employeeId);
    }
    @GetMapping()
    public List<Project> getProjects(){
        return projectService.getProjects();
    }
    @PostMapping("/addTechLead")
    public ProjectTechLeadResponse addTechLead(@RequestParam long projectId, @RequestParam long employeeId){
        return projectService.addTechLead(projectId,employeeId);
    }
    @PostMapping("/addMember")
    public ProjectMemberResponse addMember(@RequestParam long projectId, @RequestParam long employeeId){
        return projectService.addMember(projectId,employeeId);
    }
    @GetMapping("/getByCustomerName")
    public List<ProjectResponse> getByCustomerName(@RequestParam String name){
        return projectService.getByCustomerName(name);
    }
    @GetMapping("/getByName")
    public List<ProjectResponse> getByName(@RequestParam String name){
        return projectService.getByName(name);
    }
}
