package com.desafios.desafio_01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio_01.entities.Agente;
import com.desafios.desafio_01.repositories.AgenteRepository;
/*
import com.desafios.desafio_01.services.exceptions.DatabaseException;
import com.desafios.desafio_01.services.exceptions.ResourceNotFoundException;
*/
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
	
/*
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	} */
	
/*	public Agente update(Long id, Agente obj) {
		try {
			Agente entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	} */

	private void updateData(Agente entity, Agente obj) {
		entity.setNome(obj.getNome());
		entity.setData(obj.getData());
	}
}
