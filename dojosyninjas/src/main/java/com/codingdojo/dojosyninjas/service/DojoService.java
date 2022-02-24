package com.codingdojo.dojosyninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.entity.Dojo;
import com.codingdojo.dojosyninjas.repository.DojoRepository;

@Service
public class DojoService implements IDojoService {
	
	@Autowired
	private DojoRepository dojoRepository;

	@Override
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	@Override
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	@Override
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		
		return null;
	}

	@Override
	public Dojo updateDojo(Long id, Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		
		if (optionalDojo.isPresent()) {
			Dojo data = optionalDojo.get();
			data.setName(dojo.getName());
			
			return dojoRepository.save(data);
		}
		
		return null;
	}

	@Override
	public void deleteDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		
		if (optionalDojo.isPresent()) {
			dojoRepository.deleteById(id);
		}
		
	}

}
