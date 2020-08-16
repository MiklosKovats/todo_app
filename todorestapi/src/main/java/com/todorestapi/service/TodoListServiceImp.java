package com.todorestapi.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.todorestapi.entity.Priority;
import com.todorestapi.entity.Todo;
import com.todorestapi.repository.PriorityRepository;
import com.todorestapi.repository.TodoRepository;

@Service
public class TodoListServiceImp implements TodoListService {
	
	private TodoRepository todoRepository;
	private PriorityRepository priorityRepository;
	
	@Autowired
	public TodoListServiceImp (TodoRepository todoRepository, PriorityRepository priorityRepository) {
		this.todoRepository = todoRepository;
		this.priorityRepository = priorityRepository;
	}
	
	public List<Todo> getTodoList() {
		return todoRepository.findAllByOrderById();
	}
	
	public void createTodo(Todo newTodo) {
		todoRepository.save(newTodo);
	}
	
	public Priority getPriorityById(int id) {
		return priorityRepository.findById(id);
	}
	
	public void erasureTodo(int id) {
		todoRepository.deleteById(id);
	}
	
	public Todo getTodoById(int id) {
		return todoRepository.findById(id);
	}
	
	public void updateTodo(Todo modifiedTodo) {
		todoRepository.save(modifiedTodo);
	}

	public Page<Todo> findPaginated(	int pageNumber,
										int pageSize,
										String sortField,
										String sortDirection) {		
		Sort sort = 
				sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
				? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();	
				
		PageRequest pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
		return todoRepository.findAll(pageable);
	}
	
}
