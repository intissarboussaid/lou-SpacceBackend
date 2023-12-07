package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Decoration;

@Repository
public interface DecorationRepository extends JpaRepository<Decoration, Long> {
	  @Query("from Decoration where idDeco =:idDeco")
	  Decoration findDecoById(@Param("idDeco") long idDeco);
	 
	  @Query("from Decoration where name =:name")
	  List<Decoration> findByName(@Param("name") String name);

}
