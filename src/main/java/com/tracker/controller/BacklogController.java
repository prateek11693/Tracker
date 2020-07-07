package com.tracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entity.ProjectTask;
import com.tracker.service.MapValidationErrorServiceImpl;
import com.tracker.service.ProjectTaskServiceImpl;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {

	@Autowired
	private ProjectTaskServiceImpl projectTaskService;

	@Autowired
	private MapValidationErrorServiceImpl mapValidationErrorService;

	@PostMapping("/{backlog_id}")
	public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask, BindingResult result,
			@PathVariable String backlog_id) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		ProjectTask project1 = projectTaskService.addProjectTask(backlog_id, projectTask);

		return new ResponseEntity<ProjectTask>(project1, HttpStatus.CREATED);
	}

	@GetMapping("/{backlog_id}")
	public ResponseEntity<List<ProjectTask>> getProjectBacklog(@PathVariable String backlog_id) {

		return new ResponseEntity<List<ProjectTask>>(projectTaskService.findBacklogById(backlog_id), HttpStatus.OK);
	}

	@GetMapping("/{backlog_id}/{projectSequence}")
	public ResponseEntity<ProjectTask> getProjectTaskByProjectSequence(@PathVariable String backlog_id,
			@PathVariable String projectSequence) {
		return new ResponseEntity<ProjectTask>(projectTaskService.findByProjectSequence(backlog_id, projectSequence),
				HttpStatus.OK);
	}

	@PatchMapping("/{backlog_id}/{projectSequence}")
	public ResponseEntity<?> updateProjectTask(@Valid @RequestBody ProjectTask projectTask,
			@PathVariable String backlog_id, @PathVariable String projectSequence, BindingResult result) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		ProjectTask updatedTask = projectTaskService.updateByProjectSequence(projectTask, backlog_id, projectSequence);
		return new ResponseEntity<ProjectTask>(updatedTask, HttpStatus.OK);

	}

	@DeleteMapping("/{backlog_id}/{projectSequence}")
	public ResponseEntity<?> delteeProjectTask(@PathVariable String backlog_id, @PathVariable String projectSequence) {

		projectTaskService.deleteByProjectSequence(backlog_id, projectSequence);
		return new ResponseEntity<String>("ProjectTask deleted " + projectSequence + " successfully", HttpStatus.OK);

	}
}
