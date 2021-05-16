package com.AsanTestService.testservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AsanTestService.testservice.Service.UsersRolesService;
import com.AsanTestService.testservice.dto.UsersRolesDTO;
import com.AsanTestService.testservice.entity.UsersRoles;

@RestController
public class UsersRolesController {
	
	private final UsersRolesService usersrolesService;

	public UsersRolesController(UsersRolesService usersrolesService) {
		this.usersrolesService = usersrolesService;
	}
	
	@RequestMapping(value= {"/getAllUsersRoles"},method = RequestMethod.GET)
	public ResponseEntity getAllUsersRoles() {
		return usersrolesService.getUsersRolesList();
	}
    @RequestMapping(value = "/addUsersRoles",method = RequestMethod.POST)
    public ResponseEntity<UsersRoles> addRolesPost(@RequestBody UsersRolesDTO usersrolesDTO) {

        return usersrolesService.addUsersRoles(usersrolesDTO);
    }
    @RequestMapping(value= {"/editUsersRoles/{id}"} , method= RequestMethod.POST)
    public ResponseEntity<UsersRoles>  updateRoles(@PathVariable Integer id, @RequestBody UsersRolesDTO usersroleDTO) {
      
        return usersrolesService.update(id,usersroleDTO);
    }
    @RequestMapping(value= {"/deleteUsersRoles/{id}"}, method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable Integer id) {
        return usersrolesService.delete(id);
    }
	
}
