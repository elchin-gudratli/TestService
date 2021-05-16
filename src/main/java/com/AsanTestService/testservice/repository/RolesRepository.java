package com.AsanTestService.testservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsanTestService.testservice.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer>{

}
