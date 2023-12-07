package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
	  @Query("from Panier where id_panier=:id_panier")
	  Panier findById(@Param("id_panier") long id_panier);
}
