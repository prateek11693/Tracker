package com.tracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "qataskss")
public class QATask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message= "Sprint number is required")
	private Integer sprintNumber;

	@NotBlank(message = "Product is required")
	private String product;

	@NotBlank(message = "EmployeeName is required")
	private String employeeName;

	@NotBlank(message = "sprint Team is required")
	private String sprintTeam;

	@NotBlank(message = "TaskType is required")
	private String taskType;

	@NotBlank(message = "JiraId is required")
	@Column(unique = true)
	private String jiraId;

	@NotNull(message= "tcwRITTEN is required")
	private Integer tcWritten;

	@NotNull(message= "tcExecuted is required")
	private Integer tcExecuted;

	
	private Integer inSprintBug;

	private String remarks;

	
	private Date created_on;
	

	private Date updated_on;
	

	
public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

@PrePersist
protected void onCreate() {
	this.created_on= new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updated_on=new Date();
}
	
	public QATask() {

	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSprintNumber() {
		return sprintNumber;
	}

	public void setSprintNumber(Integer sprintNumber) {
		this.sprintNumber = sprintNumber;
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

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public Integer getTcWritten() {
		return tcWritten;
	}

	public void setTcWritten(Integer tcWritten) {
		this.tcWritten = tcWritten;
	}

	public Integer getTcExecuted() {
		return tcExecuted;
	}

	public void setTcExecuted(Integer tcExecuted) {
		this.tcExecuted = tcExecuted;
	}

	public Integer getInSprintBug() {
		return inSprintBug;
	}

	public void setInSprintBug(Integer inSprintBug) {
		this.inSprintBug = inSprintBug;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}