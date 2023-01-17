package com.desafios.desafio_01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio_01.entities.Agente;
import com.desafios.desafio_01.repositories.AgenteRepository;

@Service
public class AgenteService {
	
	@Autowired
	private AgenteRepository repository;
	
	public List<Agente> findAll() {
		return repository.findAll();
	}

	public Agente findById(Long id) {
		Optional<Agente> obj = repository.findById(id);
		return obj.get();
		//return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Agente insert(Agente obj) {
		return repository.save(obj);
	}

}
