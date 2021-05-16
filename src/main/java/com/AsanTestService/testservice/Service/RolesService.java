package com.AsanTestService.testservice.Service;

import org.springframework.http.ResponseEntity;

import com.AsanTestService.testservice.dto.RolesDTO;
import com.AsanTestService.testservice.entity.Roles;


public interface RolesService {

	ResponseEntity<Roles> getRolesList();
	
	ResponseEntity<Roles> addRoles(RolesDTO rolesDTO);
	
	Boolean delete(Integer id);

	Roles getById(Integer id);

	ResponseEntity<Roles> update(Integer id, RolesDTO roleDTO);
	
}
