package com.todorestapi.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todorestapi.entity.Priority;
import com.todorestapi.entity.Todo;
import com.todorestapi.service.PriorityService;
import com.todorestapi.service.TodoListService;

@Controller
public class HomeController {
	
	private TodoListService todoListService;
	private PriorityService priorityService;
	
	@Autowired
	public HomeController (TodoListService todoListService, PriorityService priorityService) {
		this.todoListService = todoListService;
		this.priorityService = priorityService;
	}

	@RequestMapping("/")
	public String showTodoList(Model model) {
		model.addAttribute("todoList", todoListService.getTodoList());
		model.addAttribute("todo", new Todo());
		return "todoList";
	}
	
	@RequestMapping("/create_todo")
	public String showCreateTodo(Model model) {
		model.addAttribute("priorities", priorityService.getPriorities());
		model.addAttribute("currentDate", new Date());
		return "createTodo";
	}
	
	@RequestMapping("/edit_todo")
	public String showEditTodo (@RequestParam(name = "id") int id, Model model) {
		model.addAttribute("priorities", priorityService.getPriorities());
		model.addAttribute("todo", todoListService.getTodoById(id));
		model.addAttribute("currentDate", new Date());
		return "editTodo";
	}
	
	@RequestMapping("/todo/create")
	public ModelAndView newTodo(	@RequestParam(name="description") String description,
									@RequestParam(name="term") String term,
									@RequestParam(name="priority") int priorityId) throws ParseException {
					
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.parse(term);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());		
		
		Priority priority = todoListService.getPriorityById(priorityId);
		Todo todo = new Todo(description, (Date) date, priority);		
		todoListService.createTodo(todo);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/todo/update")
	public ModelAndView modifyTodo(	@RequestParam(name="description") String description,
									@RequestParam(name="term") String term,
									@RequestParam(name="priority") int priorityId,
									@RequestParam(name="todo_id") int todoId) throws ParseException {
					
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.parse(term);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		
		Priority priority = todoListService.getPriorityById(priorityId);
		Todo todo = todoListService.getTodoById(todoId);		
		todo.setDescription(description);
		todo.setTerm(date);
		todo.setPriority(priority);
		todo.setModifited(new Date());
		todoListService.updateTodo(todo);
		
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/todo/remove")
	public ModelAndView removeException (@RequestParam(name = "id") String id) {
		todoListService.erasureTodo(Integer.valueOf(id));
		return new ModelAndView("redirect:/");
	}
	
}
