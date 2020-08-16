package com.todorestapi.restapi;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todorestapi.entity.Todo;
import com.todorestapi.service.TodoListService;

@RestController
@RequestMapping("/restapi")
public class RestApiController {
	
	private TodoListService todoListService;	
	
	public RestApiController(TodoListService todoListService) {
		this.todoListService = todoListService;
	}	
	
	@GetMapping("/todolist")
	public List<Todo> searchTodoList() {
		return todoListService.getTodoList();
	}
	
	@PostMapping("/todo/create")
	public Todo createTodo(@RequestBody Todo todo) {
		todoListService.createTodo(todo);
		return todo;
	}
	
	@PutMapping("/todo/update")
	public Todo updateTodo(@RequestBody Todo todo) {
		Todo originTodo = todoListService.getTodoById(todo.getId()); 
		todo.setCreated(originTodo.getCreated());
		todoListService.createTodo(todo);
		return todo;
	}
	
	@PostMapping("/todo/delete")
	public Todo deleteTodo(@RequestBody Todo todo) throws Exception {
		todoListService.erasureTodo(todo.getId());	
		return todo;
	}

}
