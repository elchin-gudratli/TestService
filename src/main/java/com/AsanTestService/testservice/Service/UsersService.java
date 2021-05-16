package com.AsanTestService.testservice.Service;

import org.springframework.http.ResponseEntity;

import com.AsanTestService.testservice.dto.UsersDTO;
import com.AsanTestService.testservice.entity.Users;



public interface UsersService {

	ResponseEntity<Users> getUsersList();
	
	Users getById(Integer id);

	ResponseEntity<Users> addUsers(UsersDTO usersDTO);

	ResponseEntity<Users> delete(Integer id);

	ResponseEntity getUserDetail(Integer id);

	ResponseEntity<Users> update(Integer id, UsersDTO userDTO);

	
}
