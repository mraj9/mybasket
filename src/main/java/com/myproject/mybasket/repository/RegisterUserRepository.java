package com.myproject.mybasket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.mybasket.user.Users;

public interface RegisterUserRepository extends JpaRepository<Users, Long> {
	 @Query("SELECT t FROM Users t where t.userName = :username and t.password= :password") 
	  Optional<Users> loginUser(@Param("username") String userName,@Param("password") String password);

}
