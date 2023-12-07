package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {
	  @Query("from Avis where id_avis=:id_avis")
	  Avis findById1(@Param("id_avis") long id_avis);

}
