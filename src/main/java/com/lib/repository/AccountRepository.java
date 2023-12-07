package com.lib.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
	  Optional<Account> findByUsername(String  username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	  
	  @Query("from Account where idaccount=:idaccount")
	  Account findById1(@Param("idaccount") long idaccount);
	  
	  @Query("from Account where username =:username")
	  Account findBysername(@Param("username")String username);
	  
	 @Query("from Account where email=:email")
	  Account findByemail(@Param("email")String email);
}
