package com.codingdojo.dojosyninjas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosyninjas.entity.Ninja;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
	List<Ninja> findAll();
}
