package com.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Backlog;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

	
	Backlog findByProjectIdentifier(String Identifier);
}
