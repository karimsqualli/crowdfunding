package org.mql.gc.models;

public class Association {
	
	private Long id;
	private String name; 
	private String description;
	
	public Association() {
		super();
	}
	public Association(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}