package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.Account;
import com.lib.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	@Query("from Admin where idAdmin=:idAdmin")
	Admin findById(@Param("idAdmin") long idAdmin);
	 @Query(value = "FROM Admin a WHERE a.idAdmin = :idAdmin")
	 Admin findByidAdmin(@Param("idAdmin") long idAdmin);
	@Query("from Admin where nameCompany=:nameCompany")
	List<Admin> findByNameCompany(@Param("nameCompany") String nameCompany);
	@Query("from Admin where firstName=:firstName")
	List<Admin> findByFirstNmae(@Param("firstName")String firstName);
	@Query("from Admin where account =:account" )
	Admin findByAccount(@Param("account") Account account);
	

	@Query("from Admin where idAdmin=:idAdmin" )
	Admin getByID(@Param("idAdmin")long idAdmin);
}
