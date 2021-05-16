package com.AsanTestService.testservice.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.AsanTestService.testservice.Service.UsersRolesService;
import com.AsanTestService.testservice.dto.UsersRolesDTO;
import com.AsanTestService.testservice.entity.Roles;
import com.AsanTestService.testservice.entity.UsersRoles;
import com.AsanTestService.testservice.repository.UsersRolesRepository;

@Transactional
@Service
public class UsersRolesServiceImpl implements UsersRolesService{

	private final UsersRolesRepository usersrolesRepository;
	
	private ModelMapper modelMapper;

	public UsersRolesServiceImpl(UsersRolesRepository usersrolesRepository,ModelMapper modelMapper) {
		this.usersrolesRepository = usersrolesRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity getUsersRolesList() {
		List<UsersRoles> list = usersrolesRepository.findAll();
		if(list != null  && list.size() > 0){
			return ResponseEntity.ok(list);
		}
		else{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UsersRoles> addUsersRoles(UsersRolesDTO usersrolesDTO) {
		UsersRoles usersroles=new UsersRoles();
		usersroles.setUser_id(usersrolesDTO.getUser_id());
		usersroles.setRole_id(usersrolesDTO.getRole_id());
		usersrolesRepository.save(usersroles);
		return ResponseEntity.ok(usersroles);
	}

	@Override
	public Boolean delete(Integer id) {
		usersrolesRepository.deleteById(id);
        return true;
	}

	@Override
	public UsersRoles getById(Integer id) {
		return usersrolesRepository.findById(id).get();
	}

	@Override
	public ResponseEntity<UsersRoles> update(Integer id, UsersRolesDTO usersroleDTO) {
		UsersRoles usersrole=getById(id);
		usersrole.setUser_id(usersroleDTO.getUser_id());
		usersrole.setRole_id(usersroleDTO.getRole_id());
		usersrolesRepository.save(usersrole);
		return ResponseEntity.ok(usersrole);
	}
	

}
