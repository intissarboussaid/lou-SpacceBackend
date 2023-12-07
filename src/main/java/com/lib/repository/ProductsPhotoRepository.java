package com.lib.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lib.models.Admin;
import com.lib.models.FileDB;
import com.lib.models.ProductsPhoto;

public interface ProductsPhotoRepository extends JpaRepository<ProductsPhoto, String>  {
	@Query(value="from ProductsPhoto where product =:product")
	Stream<ProductsPhoto> findByProduct(@Param("product") ProductsPhoto product);

}
