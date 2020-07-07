package com.tracker.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.Data;

@Component
public class DataDtoToData {

	
	
	@Autowired
	Data data;
	
	public  Data convert(DataDto dataDto) {
		
		data.setEmployeeName(dataDto.getEmployeeName());
		data.setInSprintBugCount(dataDto.getInSprintBugCount());
		data.setJiraId(dataDto.getJiraId());
		data.setProduct(dataDto.getProduct());
		data.setSprint(dataDto.getSprint());
		data.setSprintTeam(dataDto.getSprintTeam());
		data.setTaskType(dataDto.getTaskType());
		data.setTestCaseExecuted(dataDto.getTestCaseExecuted());
		data.setTestCaseWritten(dataDto.getTestCaseWritten());
		
		
		return data;
	}
}
