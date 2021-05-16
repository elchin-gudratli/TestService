package com.AsanTestService.testservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AsanTestService.testservice.Service.RolesService;
import com.AsanTestService.testservice.dto.RolesDTO;
import com.AsanTestService.testservice.entity.Roles;



@RestController
public class RolesController {

	private final RolesService rolesService;
	
	public RolesController(RolesService rolesService) {
		this.rolesService=rolesService;
	}
	
	@RequestMapping(value= {"/getAllRoles"},method = RequestMethod.GET)
	public ResponseEntity getAllRoles() {
		return rolesService.getRolesList();
	}
    @RequestMapping(value = "/addRoles",method = RequestMethod.POST)
    public ResponseEntity<Roles> addRolesPost(@RequestBody RolesDTO rolesDTO) {

        return rolesService.addRoles(rolesDTO);
    }
    @RequestMapping(value= {"/editRoles/{id}"} , method= RequestMethod.POST)
    public ResponseEntity<Roles>  updateRoles(@PathVariable Integer id, @RequestBody RolesDTO roleDTO) {
      
        return rolesService.update(id,roleDTO);
    }
    @RequestMapping(value= {"/deleteRoles/{id}"}, method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable Integer id) {
        return rolesService.delete(id);
    }
}
