package co.grandcircus.tasklist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	// annotate many-to-one relationships
		@ManyToOne
	private User user;
	private String description;
	private String dueDate;
	private Boolean complete;
	
	public Task(Long id, User user, String description, String dueDate, Boolean complete) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
	}
	
	public Task() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	
	
	
}
