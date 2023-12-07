package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {
	  @Query("from Clothes where id_clothes=:id_clothes")
	  Clothes findById(@Param("id_clothes") long id_clothes);
	  @Query("from Clothes ")
	 List< Clothes> findAll();
}
