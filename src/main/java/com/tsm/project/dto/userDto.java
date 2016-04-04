package com.tsm.project.dto;

public class userDto {

	private int id ;
	private String role ;
	
	public userDto(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public userDto() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
