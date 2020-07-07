package com.tracker.exception;

public class ProjectNotFoundExceptionResponse {

	String projectNotFound;

	public ProjectNotFoundExceptionResponse(String projectNotFound) {

		this.projectNotFound = projectNotFound;
	}

	public String getProjectNotFound() {
		return projectNotFound;
	}

	public void setProjectNotFound(String projectNotFound) {
		this.projectNotFound = projectNotFound;
	}

}
