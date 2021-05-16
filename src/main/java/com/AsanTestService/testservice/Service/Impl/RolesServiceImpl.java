package com.AsanTestService.testservice.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.AsanTestService.testservice.Service.RolesService;
import com.AsanTestService.testservice.dto.RolesDTO;
import com.AsanTestService.testservice.entity.Roles;
import com.AsanTestService.testservice.repository.RolesRepository;


@Transactional
@Service
public class RolesServiceImpl implements RolesService{
	
	private final RolesRepository rolesRepository;
	

	private final ModelMapper modelMapper;
	
	public RolesServiceImpl(RolesRepository rolesRepository,ModelMapper modelMapper) {
		this.rolesRepository = rolesRepository;
		this.modelMapper = modelMapper;
		
	}

	@Override
	public ResponseEntity getRolesList() {
		List<Roles> list = rolesRepository.findAll();
		if(list != null  && list.size() > 0){
			return ResponseEntity.ok(list);
		}
		else{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Roles> addRoles(RolesDTO rolesDTO) {
		Roles roles= new Roles();
		roles.setRolename(rolesDTO.getRolename());
		rolesRepository.save(roles);
		return ResponseEntity.ok(roles);
	}

	@Override
	public Boolean delete(Integer id) {
		rolesRepository.deleteById(id);
        return true;
	}
	@Override
	public Roles getById(Integer id) {
		return rolesRepository.findById(id).get();
	}


	@Override
	public ResponseEntity<Roles> update(Integer id,RolesDTO roleDTO) {
		Roles roles=getById(id);
		roles.setRolename(roleDTO.getRolename());
		rolesRepository.save(roles);
		return ResponseEntity.ok(roles);
	}

}
