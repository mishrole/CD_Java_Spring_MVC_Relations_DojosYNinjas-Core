package com.codingdojo.dojosyninjas.service;

import java.util.List;

import com.codingdojo.dojosyninjas.entity.Ninja;

public interface INinjaService {
	public abstract List<Ninja> allNinjas();
	public abstract Ninja createNinja(Ninja ninja);
	public abstract Ninja findNinja(Long id);
	public abstract Ninja updateNinja(Long id, Ninja ninja);
	public abstract void deleteNinja(Long id);
}
