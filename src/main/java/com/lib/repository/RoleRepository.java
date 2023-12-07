package com.lib.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.models.ERole;
import com.lib.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    
    //Optional<Role> findByName11(String  name);
    @Query("FROM Role WHERE id =: id")
    Role findNyId(@Param("id") long id);
    @Query("FROM Role WHERE name =: name")
    Role findByName1(@Param("name") ERole name);
    @Query("FROM Role ")
    List<Role> All();
}
