package com.desafios.desafio_01.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.desafio_01.entities.Regiao;
import com.desafios.desafio_01.repositories.RegiaoRepository;
import com.desafios.desafio_01.services.RegiaoService;

@RestController
@RequestMapping(value = "/regioes")
public class RegiaoResource {

	private RegiaoService service;

	private RegiaoRepository regiaoRepository;
	
	@PersistenceContext
	EntityManager em;


	@GetMapping
	public ResponseEntity<List<Regiao>> findAll() {
		List<Regiao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Regiao> findById(@PathVariable Long id) {
		Regiao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//@GetMapping("/consolida")
	//public ResponseEntity<List<Regiao>> consolida() {	
	//	Query q = manager.createNamedQuery("SELECT sigla, codigo, sum(preco_compra) as compra, sum(preco_medio) as pmedio, sum(geracao) as geracao FROM TB_REGIAO GROUP BY sigla ORDER BY sigla");
		//List<Regiao> lista = regiaoRepository.resumao();
		
		//return ResponseEntity.ok().body(lista);

	//}	
	
	@GetMapping("/findSum")
    public List<Regiao> findSum() {
		/*Query query =  =  em.getNamedQuery("resumao");*/
		Query query = (Query) em.createNativeQuery("SELECT * FROM Regiao", "resumao2");
		@SuppressWarnings("unchecked")
		List<Regiao> lista = query.getResultList();
        return lista;
    }
		/*
		String sqlstr = "SELECT sigla, codigo, " + "	sum(preco_compra) as compra, sum(preco_medio) as pmedio,"
				+ " sum(geracao) as geracao FROM " + " TB_REGIAO GROUP BY sigla ORDER BY sigla";
		@Query(value = sqlstr, nativeQuery = true)
		Page<CustomProjection> customQuery(Pageable pageable);
	
	}*/
}
