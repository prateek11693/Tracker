package com.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Data;

@Repository
public interface TrackerRepository extends JpaRepository<Data,String>{
	

	
}
