package com.lib.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.Admin;
import com.lib.models.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	  @Query("from Product where idproduct = :idproduct")
	  Product findById(@Param("idproduct") long idproduct);
	  
	  @Query(value = "FROM Product b WHERE b.idproduct = :idproduct")
	  Product findByIdProduct(@Param("idproduct") long idproduct);
	  
	  @Query(value = "FROM Product b WHERE b.productActualPrice >= :productActualPrice")
	 List< Product> findByPrice(@Param("productActualPrice") float productActualPrice);
	  
	  @Query(value = "from Product where admin = :admin")
	  List<Product> findByIdAdmin(@Param("admin") Admin admin);

}
