package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.exception.ProjectIdException;
import com.tracker.dao.BacklogRepository;
import com.tracker.dao.ProjectRespository;
import com.tracker.entity.Backlog;
import com.tracker.entity.Project;

@Service
public class ProjectServiceImpl {

	@Autowired
	private ProjectRespository projectRespository;
	
	@Autowired
	private BacklogRepository backlogRepository;

	public Project saveOrUpdateProject(Project project) {

		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

			if (project.getId() == null) {
				Backlog backlog = new Backlog();

				project.setBacklog(backlog);
				backlog.setProject(project);
				backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			}
			if(project.getId()!=null) {
				project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
			}

			return projectRespository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project ID" + project.getProjectIdentifier().toUpperCase() + " Already exists");
		}
	}

	public Project findByProjectIdentifier(String projectId) {
		Project project = projectRespository.findByProjectIdentifier(projectId.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project ID does not exists");

		}
		return project;
	}

	public List<Project> findAll() {

		List<Project> list = new ArrayList<>();
		list = projectRespository.findAll();

		return list;

	}

	public void deleteByProjectIdentifier(String projectId) {

		Project project = projectRespository.findByProjectIdentifier(projectId);

		if (project == null) {
			throw new ProjectIdException("Project ID does not exists");
		}

		projectRespository.delete(project);
	}
}
