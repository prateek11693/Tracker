package com.tracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Project;

@Repository
public interface ProjectRespository extends JpaRepository<Project, Long> {

	Project findByProjectIdentifier(String projectId);
	

	List<Project> findAll();
}
