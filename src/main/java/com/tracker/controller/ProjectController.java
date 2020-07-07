package com.tracker.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entity.Project;
import com.tracker.service.MapValidationErrorServiceImpl;
import com.tracker.service.ProjectServiceImpl;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectService;

	@Autowired
	private MapValidationErrorServiceImpl mapValidationErrorService;

	@PostMapping("/project")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Project projectSaved = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(projectSaved, HttpStatus.CREATED);

	}

	@GetMapping("/project/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
		
		Project project=projectService.findByProjectIdentifier(projectId);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@GetMapping("/project")
	public ResponseEntity<?> getAllProjects(){
		List<Project> projects= projectService.findAll();
		return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteById(@PathVariable String projectId){
		projectService.deleteByProjectIdentifier(projectId);
		return new ResponseEntity<String>("Project deleted",HttpStatus.OK);
	}
}
