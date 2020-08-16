package com.todorestapi.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.todorestapi.entity.Todo;

@Service
public interface TodoListService {
	
	Page<Todo> findPaginated(	int pageNumber,
								int pageSize,
								String sortField,
								String sortDirection);

}
