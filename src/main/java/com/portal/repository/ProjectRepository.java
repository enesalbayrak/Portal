package com.portal.repository;

import com.portal.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> getAllByProjectName(String name);
    List<Project> getAllByCustomerFullname(String name);
}
