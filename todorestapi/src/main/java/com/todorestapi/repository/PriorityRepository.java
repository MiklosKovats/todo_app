package com.todorestapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todorestapi.entity.Priority;

@Repository
public interface PriorityRepository extends CrudRepository<Priority, Integer> {
	
	Priority findById(int id);
	
	List<Priority> findAll();
	
}
