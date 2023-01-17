package com.desafios.desafio_01.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio_01.entities.Regiao;
import com.desafios.desafio_01.repositories.RegiaoRepository;


@Service
public class RegiaoService {

	@Autowired
	private EntityManager manager;
	
	private RegiaoRepository repository;
	private Regiao entityRegiao;


	public List<Regiao> findAll() {
		return repository.findAll();
	}
/*
	public List<Regiao> findByResumo() {
		return repository.resumao();
	} */

	public Regiao findById(Long id) {
		Optional<Regiao> obj = repository.findById(id);
		return obj.get();
		// return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Regiao insert(Regiao obj) {
		return repository.save(obj);
	}

	/*
	 * public void delete(Long id) { try { repository.deleteById(id); } catch
	 * (EmptyResultDataAccessException e) { throw new ResourceNotFoundException(id);
	 * } catch (DataIntegrityViolationException e) { throw new
	 * DatabaseException(e.getMessage()); } }
	 */

	/*
	 * public Regiao update(Long id, Regiao obj) { try { Regiao entity =
	 * repository.getReferenceById(id); updateData(entity, obj); return
	 * repository.save(entity); } catch (EntityNotFoundException e) { throw new
	 * ResourceNotFoundException(id); } }
	 */

}
