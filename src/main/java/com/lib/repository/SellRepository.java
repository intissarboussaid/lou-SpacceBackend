package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lib.models.Sell;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long>{
	  @Query("from Sell where id_sell=:id_sell")
	  Sell findById(@Param("id_sell") long id_sell);
}
