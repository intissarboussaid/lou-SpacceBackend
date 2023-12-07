package com.lib.repository;


import java.util.List;
import java.util.stream.Stream;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.Admin;
import com.lib.models.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {
	
	
	@Query(value="from FileDB where admin =:admin")
	Stream<FileDB> findByAdmin(@Param("admin") Admin admin);
	
	@Query(value="from FileDB where name =:name")
	List<FileDB> findByname(@Param("name") String name);

}
