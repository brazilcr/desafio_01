package com.desafios.desafio_01.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio_01.entities.Regiao;
import com.desafios.desafio_01.repositories.RegiaoRepository;
/*
import com.desafios.desafio_01.services.exceptions.DatabaseException;
import com.desafios.desafio_01.services.exceptions.ResourceNotFoundException;
*/
@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;
	
	public List<Regiao> findAll() {
		return repository.findAll();
	}

	public Regiao findById(Long id) {
		Optional<Regiao> obj = repository.findById(id);
		return obj.get();
		//return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Regiao insert(Regiao obj) {
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
	
/*	public Regiao update(Long id, Regiao obj) {
		try {
			Regiao entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	} */
	
	private void updateData(Regiao entity, Regiao obj) {
		entity.setNome(obj.getNome());
		entity.setCompra(obj.getCompra());
		entity.setGeracao(obj.getGeracao());		
		entity.setpMedio(obj.getpMedio());
	}
	
	
}
