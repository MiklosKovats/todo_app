package com.todorestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todorestapi.entity.Priority;
import com.todorestapi.entity.Todo;
import com.todorestapi.repository.PriorityRepository;
import com.todorestapi.repository.TodoRepository;

@Service
public class TodoListService {
	
	private TodoRepository todoRepository;
	private PriorityRepository priorityRepository;
	
	@Autowired
	public TodoListService (TodoRepository todoRepository, PriorityRepository priorityRepository) {
		this.todoRepository = todoRepository;
		this.priorityRepository = priorityRepository;
	}
	
	public List<Todo> getTodoList() {
		return todoRepository.findAll();
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
	
}
