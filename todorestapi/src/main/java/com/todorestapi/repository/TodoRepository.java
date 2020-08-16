package com.todorestapi.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.todorestapi.entity.Todo;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Integer> {
	
	List<Todo> findAllByOrderById();
	
	Todo findById(int id);
	
}
