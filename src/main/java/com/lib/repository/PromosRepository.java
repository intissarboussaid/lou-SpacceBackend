package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Promos;

@Repository
public interface PromosRepository extends JpaRepository<Promos, Long> {
	  @Query("from Promos where id_promos=:id_promos")
	  Promos findById(@Param("id_promos") long id_promos);

}
