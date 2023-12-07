package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Favoris;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, Long> {
	  @Query("from Favoris where id_favoris=:id_favoris")
	  Favoris findById1(@Param("id_favoris") long id_favoris);
}
