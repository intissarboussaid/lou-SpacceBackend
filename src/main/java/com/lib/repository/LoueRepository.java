package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Loue;

@Repository
public interface LoueRepository extends JpaRepository<Loue, Long>{
	  @Query("from Loue where id_louer=:id_louer")
	  Loue findById1(@Param("id_louer") long id_louer);
}
