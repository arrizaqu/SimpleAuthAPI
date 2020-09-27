package com.arrizaqu.test.myecommerce.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arrizaqu.test.myecommerce.entity.Users;

public interface UsersRepo extends JpaRepository<Users, String>{

	@Query("FROM Users u JOIN FETCH u.roles r where u.email = :datalogin or u.mobileNumber = :datalogin")
	Users findByEmail(@Param("datalogin") String datalogin);

	@Modifying
	@Query("UPDATE Users u SET u.firstName = :firstName,"
			+ "u.lastName = :lastName,"
			+ "u.gender = :gender,"
			+ "u.dateOfBirth = :format "
			+ "Where u.id = :id")
	void updateUserInfo(
			@Param("id") String id,
			@Param("firstName") String firstName, 
			@Param("lastName") String lastName, 
			@Param("gender") String gender, 
			@Param("format") Date format);

}
