package com.codingdojo.dojosyninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.entity.Ninja;
import com.codingdojo.dojosyninjas.repository.NinjaRepository;

@Service
public class NinjaService implements INinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;

	@Override
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

	@Override
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	@Override
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		
		return null;
	}

	@Override
	public Ninja updateNinja(Long id, Ninja ninja) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		
		if (optionalNinja.isPresent()) {
			Ninja data = optionalNinja.get();
			data.setAge(ninja.getAge());
			data.setFirstName(ninja.getFirstName());
			data.setLastName(ninja.getLastName());
			data.setDojo(ninja.getDojo());
			
			return ninjaRepository.save(data);
		}
		
		return null;
	}

	@Override
	public void deleteNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		
		if (optionalNinja.isPresent()) {
			ninjaRepository.deleteById(id);
		}
	}

}
