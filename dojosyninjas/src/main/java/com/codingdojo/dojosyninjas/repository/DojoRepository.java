package com.codingdojo.dojosyninjas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosyninjas.entity.Dojo;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, Long> {
	List<Dojo> findAll();
}
