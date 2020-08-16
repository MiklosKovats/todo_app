package com.todorestapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "priorities")
public class Priority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String priority;
	@JsonBackReference
	@OneToMany(mappedBy = "priority")
	private List<Todo> todoList;
		
	
	public Priority() {}

	public Integer getId() {
		return id;
	}

	public String getPriority() {
		return priority;
	}

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}	
	
}
