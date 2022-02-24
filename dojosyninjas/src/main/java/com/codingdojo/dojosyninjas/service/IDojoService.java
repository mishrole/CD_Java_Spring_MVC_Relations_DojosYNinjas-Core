package com.codingdojo.dojosyninjas.service;

import java.util.List;

import com.codingdojo.dojosyninjas.entity.Dojo;

public interface IDojoService {
	public abstract List<Dojo> allDojos();
	public abstract Dojo createDojo(Dojo dojo);
	public abstract Dojo findDojo(Long id);
	public abstract Dojo updateDojo(Long id, Dojo dojo);
	public abstract void deleteDojo(Long id);
}
