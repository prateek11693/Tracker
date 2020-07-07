package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dao.QATaskRepository;
import com.tracker.dao.TrackerRepository;
import com.tracker.dto.DataDto;
import com.tracker.entity.Data;
import com.tracker.entity.QATask;
import com.tracker.exception.TaskNotfoundException;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	TrackerRepository trackerRepository;

	@Autowired
	QATaskRepository qaRepository;

	@Override
	public List<Data> findAll() {
		List<Data> datas = new ArrayList<>();

		trackerRepository.findAll().forEach(datas::add);

		return datas;
	}

	@Override
	public void save(Data data) {
		// TODO Auto-generated method stub

		trackerRepository.save(data);

	}

	@Override
	public QATask addTask(QATask task) {
		return qaRepository.save(task);

	}

	@Override
	public List<QATask> getTasks() {
		
		List<QATask> tasks=new ArrayList<>();
		qaRepository.findAll().forEach(tasks::add);
		return tasks;
		
	}

	@Override
	public QATask getByJiraId(String jiraId) {
	QATask	task =qaRepository.findByJiraId(jiraId);
	if(task==null) {
		throw new TaskNotfoundException("Task not found");
	}
	
	return task;
	}

	@Override
	public List<QATask> getBysprintNumbers(List<Integer> sprintnumbers) {
		
		List<QATask> tasks=qaRepository.findBySprintnumbers(sprintnumbers);
		
		return tasks;
	}

}
