package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.models.RoleYoutube;

@Repository
public interface RoleYoutubeRepository extends JpaRepository<RoleYoutube, String> {

}
