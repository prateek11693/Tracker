package com.tracker.service;

import java.util.List;



import com.tracker.dto.DataDto;
import com.tracker.entity.Data;
import com.tracker.entity.QATask;

public interface DataService {
	
	List<Data> findAll();
	
	

	void save(Data data);
	
	QATask addTask(QATask task);
	
	List<QATask> getTasks();



	QATask getByJiraId(String jiraId);



	List<QATask> getBysprintNumbers(List<Integer> sprintnumbers);
	
	

}
