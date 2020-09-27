package com.arrizaqu.test.myecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arrizaqu.test.myecommerce.entity.Roles;
import com.arrizaqu.test.myecommerce.entity.Users;

public interface RolesRepo extends JpaRepository<Roles, String> {

	List<Roles> findByUsersIn(List<Users> listUsers);

	@Query("FROM Roles r where r.name = :name")
	List<Roles> findByName(@Param("name") String name);

}
