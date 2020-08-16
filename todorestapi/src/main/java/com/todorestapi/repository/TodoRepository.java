package com.todorestapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todorestapi.entity.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
	
	List<Todo> findAll();
	
	Todo findById(int id);
	
}
