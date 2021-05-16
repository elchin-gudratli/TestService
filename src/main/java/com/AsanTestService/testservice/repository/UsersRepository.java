package com.AsanTestService.testservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AsanTestService.testservice.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{

	List<Users> findAll();

	Users getById(Integer id);

	Optional<Users> findByUsername(String username);

	@Query(value = "select u from Users u where u.id =:userId")
	Users getUserDetail( @Param("userId") Integer id);


}
