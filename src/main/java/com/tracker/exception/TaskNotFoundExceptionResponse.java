package com.tracker.exception;

public class TaskNotFoundExceptionResponse {
	
	String jiraId;

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public TaskNotFoundExceptionResponse(String jiraId) {
		
		this.jiraId = jiraId;
	}
	

}
