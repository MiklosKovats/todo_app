package com.todorestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todorestapi.entity.Priority;
import com.todorestapi.repository.PriorityRepository;

@Service
public class PriorityService {

	private PriorityRepository priorityRepository;
	
	@Autowired
	public PriorityService (PriorityRepository priorityRepository) {
		this.priorityRepository = priorityRepository;
	}
	
	public List<Priority> getPriorities() {
		return priorityRepository.findAll();
	}
	
}
