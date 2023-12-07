package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Commande;

@Repository
public interface CommandRepository extends JpaRepository<Commande, Long> {
	  @Query("from Commande where idCommande=:idCommande")
	  Commande findById1(@Param("idCommande") long idCommande);
}
