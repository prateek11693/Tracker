package com.tracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

	
	List<ProjectTask> findByProjectidentifierOrderByPriority(String id);
	
	ProjectTask findByProjectSequence(String id);
}
