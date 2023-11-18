package com.app.devgpt.repository;

import com.app.devgpt.model.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDetailsRepository  extends JpaRepository<ProjectDetails, Long>
{
	public ProjectDetails findByProjectId(Long projectId);
	public ProjectDetails findByProjectName(String projectName);
	public ProjectDetails findByProjectIdAndProjectName(Long projectId, String projectName);
}
