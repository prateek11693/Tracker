package com.tracker.dto;



import org.springframework.stereotype.Component;

@Component
public class DataDto {

	private String jiraId;

	private int sprint;

	private String product;

	private String employeeName;

	private String sprintTeam;

	private String taskType;

	private int testCaseWritten;

	private int testCaseExecuted;

	private int inSprintBugCount;

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public int getSprint() {
		return sprint;
	}

	public void setSprint(int sprint) {
		this.sprint = sprint;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getSprintTeam() {
		return sprintTeam;
	}

	public void setSprintTeam(String sprintTeam) {
		this.sprintTeam = sprintTeam;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public int getTestCaseWritten() {
		return testCaseWritten;
	}

	public void setTestCaseWritten(int testCaseWritten) {
		this.testCaseWritten = testCaseWritten;
	}

	public int getTestCaseExecuted() {
		return testCaseExecuted;
	}

	public void setTestCaseExecuted(int testCaseExecuted) {
		this.testCaseExecuted = testCaseExecuted;
	}

	public int getInSprintBugCount() {
		return inSprintBugCount;
	}

	public void setInSprintBugCount(int inSprintBugCount) {
		this.inSprintBugCount = inSprintBugCount;
	}

}
