package com.todorestapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "todo_list")
public class Todo {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;
	
	private Date term;
	
	private Date created = new Date();
	
	private Date modifited = new Date();
	
	@ManyToOne
	@JoinColumn(name = "priority_id")
	private Priority priority;
		
	public Todo() {}
		
	public Todo(String description, Date term, Priority priority) {
		this.description = description;
		this.priority = priority;
		this.term = term;
	}

	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getTerm() {
		return term;
	}
	
	public void setTerm(Date term) {
		this.term = term;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public Date getModifited() {
		return modifited;
	}

	public void setModifited(Date modifited) {
		this.modifited = modifited;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", term=" + term + ", created=" + created
				+ ", priority=" + priority + "]";
	}
		
}
