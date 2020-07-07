package com.tracker.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tracker.entity.QATask;

@Repository
public interface QATaskRepository extends JpaRepository<QATask,Long>{
	
	List<QATask> findAll();
	
	QATask save(QATask task);


	QATask findByJiraId(String jiraId);


	@Query(value="Select q from QATask q where q.sprintNumber in :sprintnumbers")
	List<QATask> findBySprintnumbers(@Param("sprintnumbers") Collection<Integer> sprintnumbers);
	
	//@Query(value="Select * from qatasks q where q.sprint_number in :sprintnumbers", nativeQuery=true)
	//List<QATask> findBySprintnumbers(@Param("sprintnumbers") Collection<Integer> sprintnumbers);
}
