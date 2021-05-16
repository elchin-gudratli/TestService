package com.AsanTestService.testservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsanTestService.testservice.entity.UsersRoles;

@Repository
public interface UsersRolesRepository  extends JpaRepository<UsersRoles, Integer>{

}
