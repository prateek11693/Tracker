package com.tracker.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="Data")
public class Data {

	@Id
	@Column(name="jira_ID")
	private String jiraId;
	
	@Column(name="sprint_number")
	private int sprint;
	
	@Column(name="product")
	private String product;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="sprint_team")
	private String sprintTeam;
	
	@Column(name="task_type")
	private String taskType;
	
	@Column(name="testcase_written")
	private int testCaseWritten;
	
	@Column(name="testcase_executed")
	private int testCaseExecuted;
	
	@Column(name="insprint_bugcount")
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
	
	@Override
	public String toString() {
		return "Data [jiraId=" + jiraId + ", sprint=" + sprint + ", product=" + product + ", employeeName="
				+ employeeName + ", sprintTeam=" + sprintTeam + ", taskType=" + taskType + ", testCaseWritten="
				+ testCaseWritten + ", testCaseExecuted=" + testCaseExecuted + ", inSprintBugCount=" + inSprintBugCount
				+ "]";
	}
	
	
	
}
