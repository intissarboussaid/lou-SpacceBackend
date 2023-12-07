package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.UserYoutube;

@Repository
public interface UserYoutubeRepository extends JpaRepository<UserYoutube, String>{
	
	@Query("from UserYoutube where userName=:userName")
	UserYoutube findByIdUser(@Param("userName") String userName);

}
