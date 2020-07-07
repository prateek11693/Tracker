package com.tracker.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.Data;

@Component
public class DataToDatadto {

	
	public static DataDto convert(Data data) {
		
		DataDto dataDto=new DataDto();
		
		dataDto.setEmployeeName(data.getEmployeeName());
		dataDto.setInSprintBugCount(data.getInSprintBugCount());
		dataDto.setJiraId(data.getJiraId());
		dataDto.setProduct(data.getProduct());
		dataDto.setSprint(data.getSprint());
		dataDto.setSprintTeam(data.getSprintTeam());
		dataDto.setTaskType(data.getTaskType());
		dataDto.setTestCaseExecuted(data.getTestCaseExecuted());
		dataDto.setTestCaseWritten(data.getTestCaseWritten());
		
		return dataDto;
	}
}
