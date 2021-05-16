package com.AsanTestService.testservice.dto;

public class UsersRolesDTO {
	
	private Integer id;
	private Integer user_id;
	private Integer role_id;
	
	public UsersRolesDTO(Integer id, Integer user_id, Integer role_id) {
		this.id = id;
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

}
