package com.AsanTestService.testservice.Service;

import org.springframework.http.ResponseEntity;

import com.AsanTestService.testservice.dto.UsersRolesDTO;
import com.AsanTestService.testservice.entity.UsersRoles;

public interface UsersRolesService {

    ResponseEntity<UsersRoles> getUsersRolesList();
	
	ResponseEntity<UsersRoles> addUsersRoles(UsersRolesDTO usersrolesDTO);
	
	Boolean delete(Integer id);

	UsersRoles getById(Integer id);

	ResponseEntity<UsersRoles> update(Integer id, UsersRolesDTO usersroleDTO);
	
}
