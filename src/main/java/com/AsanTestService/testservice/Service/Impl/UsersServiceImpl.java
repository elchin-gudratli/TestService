package com.AsanTestService.testservice.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.AsanTestService.testservice.Service.UsersService;
import com.AsanTestService.testservice.dto.UsersDTO;
import com.AsanTestService.testservice.entity.Users;
import com.AsanTestService.testservice.repository.UsersRepository;

@Transactional
@Service
public class UsersServiceImpl implements UsersService{


	private final UsersRepository usersRepository;

	private final ModelMapper modelMapper;

	public UsersServiceImpl(UsersRepository usersRepository,ModelMapper modelMapper) {
		this.usersRepository = usersRepository;
		this.modelMapper = modelMapper;

	}
	@Override
	public ResponseEntity getUsersList() {
		List<Users> list = usersRepository.findAll();
		if(list != null  && list.size() > 0){
			return ResponseEntity.ok(list);
		}
		else{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public Users getById(Integer id) {
		return usersRepository.findById(id).get();
	}

	@Override
	public ResponseEntity<Users> addUsers(UsersDTO userDTO) {
		Users users = new Users();
		users.setName(userDTO.getName());
		users.setSurname(userDTO.getSurname());
		users.setPassword(userDTO.getPassword());
		users.setUsername(userDTO.getUsername());
		usersRepository.save(users);
		return ResponseEntity.ok(users);
	}




	@Override
	public ResponseEntity<Users> delete(Integer id) {
		Optional<Users> usersOptional=usersRepository.findById(id);
		if (usersOptional.isPresent()){
			usersRepository.deleteById(id);
			return ResponseEntity.ok(usersOptional.get());
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Users> getUserDetail(Integer id) {
		Users user = usersRepository.getUserDetail(id);
		if(user != null){
			return ResponseEntity.ok(user);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Users> update(Integer id, UsersDTO userDTO) {

		Users user=getById(id);
		if(user != null) {
			user.setName(userDTO.getName());
			user.setSurname(userDTO.getSurname());
			user.setPassword(userDTO.getPassword());
			user.setUsername(userDTO.getUsername());
		}
		usersRepository.save(user);
		return ResponseEntity.ok(user);
	}

}


