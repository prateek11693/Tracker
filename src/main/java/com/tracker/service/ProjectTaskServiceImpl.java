package com.tracker.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dao.BacklogRepository;
import com.tracker.dao.ProjectTaskRepository;
import com.tracker.entity.Backlog;
import com.tracker.entity.ProjectTask;
import com.tracker.exception.ProjectNotFoundException;

@Service
public class ProjectTaskServiceImpl {

	@Autowired
	private BacklogRepository backlogRepository;

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);

		projectTask.setBacklog(backlog);
		Integer backlogSequence = backlog.getPTSequence();
		backlogSequence++;
		backlog.setPTSequence(backlogSequence);
		projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
		projectTask.setProjectidentifier(projectIdentifier);

		if (projectTask.getPriority() == null) {
			projectTask.setPriority(3);
		}

		if (projectTask.getStatus() == null) {
			projectTask.setStatus("TO_DO");
		}

		return projectTaskRepository.save(projectTask);

	}

	public List<ProjectTask> findBacklogById(String backlog_id) {

		return projectTaskRepository.findByProjectidentifierOrderByPriority(backlog_id);
	}

	public ProjectTask findByProjectSequence(String backlog_id, String projectSequence) {

		Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);

		if (backlog == null) {
			throw new ProjectNotFoundException("Project Id " + backlog_id + " Not found");
		}

		ProjectTask projectTask = projectTaskRepository.findByProjectSequence(projectSequence);

		if (projectTask == null) {
			throw new ProjectNotFoundException("Project Task with id  " + projectSequence + " Not found");
		}

		if (!projectTask.getProjectidentifier().equals(backlog_id)) {
			throw new ProjectNotFoundException(
					"Project Task " + projectSequence + " doesnt exist in project " + backlog_id);

		}

		return projectTask;
	}

	public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id, String projectSequence) {

		ProjectTask projectTask = findByProjectSequence(backlog_id, projectSequence);

		projectTask = updatedTask;
		return projectTaskRepository.save(projectTask);
	}

	public void deleteByProjectSequence(String backlog_id, String projectSequence) {
		
		ProjectTask projectTask = findByProjectSequence(backlog_id, projectSequence);
		
		Backlog backlog=projectTask.getBacklog();
		List<ProjectTask> pts = backlog.getProjectTasks();
		pts.remove(projectTask);
		backlogRepository.save(backlog);
		projectTaskRepository.delete(projectTask);
		
	}

}
