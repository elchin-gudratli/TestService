package com.AsanTestService.testservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AsanTestService.testservice.Service.UsersService;
import com.AsanTestService.testservice.dto.UsersDTO;
import com.AsanTestService.testservice.entity.Users;



@RestController
public class UsersController {
	   private final UsersService usersService;
	    
	    public UsersController(UsersService usersService) {
	    	this.usersService=usersService;
	    }

	    @RequestMapping(value = {"/getAllUsers", "test"}, method = RequestMethod.GET)
	    public ResponseEntity getAllUsers(){
	    	return usersService.getUsersList();
	    }

	    @RequestMapping(value = "/addUsers",method = RequestMethod.POST)
	    public ResponseEntity<Users> addUserPost(@RequestBody UsersDTO usersDTO) {

	        return usersService.addUsers(usersDTO);
	    }
	    @RequestMapping(value= {"/deleteUsers/{id}"}, method = RequestMethod.DELETE)
	    public ResponseEntity<Users> delete(@PathVariable Integer id) {
	        return usersService.delete(id);
	    }

	    @RequestMapping(value= {"/editUsers/{id}"} , method= RequestMethod.PUT)
	    public ResponseEntity<Users>  updateUsers(@PathVariable Integer id, @RequestBody UsersDTO userDTO) {
	      
	        return usersService.update(id,userDTO);
	    }

	    @RequestMapping(value = "/userProfile/{userid}", method = RequestMethod.GET)
	    public ResponseEntity clientlistdetail(@PathVariable("userid") Integer userid) {
	        return usersService.getUserDetail(userid);
	    }


}
