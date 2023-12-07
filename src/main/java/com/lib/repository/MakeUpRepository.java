package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.MakeUp;

@Repository
public interface MakeUpRepository extends JpaRepository<MakeUp, Long>{
	  @Query("from MakeUp where idmakeUp=:idmakeUp")
	  MakeUp findById(@Param("idmakeUp") long idmakeUp);
}
