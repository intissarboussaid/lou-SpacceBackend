package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.Client;
import com.lib.models.Account;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("from Client where firstName=:firstName")
	List<Client> findByFirstNmae(@Param("firstName")String firstName);
	@Query("from Client" )
	List<Client> getAll();
	@Query("from Client where account=:account")
	Client findByAcocunt(@Param("account")Account account);

	@Query("from Client where id_client=:id_client" )
	Client getByID(@Param("id_client")long id_client);
	
}
