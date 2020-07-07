package com.tracker.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dto.DataDto;
import com.tracker.dto.DataDtoToData;
import com.tracker.dto.DataToDatadto;
import com.tracker.entity.Data;
import com.tracker.entity.QATask;
import com.tracker.service.DataService;
import com.tracker.service.MapValidationErrorServiceImpl;

@RestController
@RequestMapping("/api")
public class TrackerController {

	@Autowired
	DataService dataService;

	@Autowired
	DataToDatadto datatoDatadto;
	
	@Autowired
	DataDtoToData dataDtotoData;

	@Autowired 
	private MapValidationErrorServiceImpl mapValidationErrorService;
	
	@GetMapping("/data")
	public List<Data> getAllData() {

		
//		List<DataDto> dataDto = new ArrayList<>();
//
//		for(Data data : dataService.findAll()) {
//			dataDto.add(datatoDatadto.convert(data));
//		}

		return dataService.findAll();

	}
	
	@PostMapping("/data")
	public ResponseEntity<DataDto> postData(@RequestBody DataDto dataDto) {
		
		dataService.save(dataDtotoData.convert(dataDto));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/qatask")
	public ResponseEntity<?> addTask(@Valid @RequestBody QATask task, BindingResult result){
		
	ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			return errorMap;
		}
		
		QATask createdTask=dataService.addTask(task);
		return new ResponseEntity<QATask>(createdTask,HttpStatus.CREATED);
	}
	
	@GetMapping("/tracker")
	public ResponseEntity<?> getTasks(){
		
		List<QATask> tasks= dataService.getTasks();
		return new ResponseEntity<List<QATask>>(tasks,HttpStatus.OK);
	}
	
	@GetMapping("/tracker/{jiraId}")
	public ResponseEntity<?> getTaskByJiraId(@PathVariable String jiraId){
		
		QATask task=dataService.getByJiraId(jiraId);
		return new ResponseEntity<QATask>(task,HttpStatus.OK);
		
	}
	
	@GetMapping("/tracker/sprint")
	public ResponseEntity<?> getBySprintNumbers(@RequestParam(name="sprintnumbers") List<Integer> sprintnumbers){
		
		
		List<QATask> tasks= dataService.getBysprintNumbers(sprintnumbers);
		
		return new ResponseEntity<List<QATask>>(tasks,HttpStatus.OK);
	}
	
}