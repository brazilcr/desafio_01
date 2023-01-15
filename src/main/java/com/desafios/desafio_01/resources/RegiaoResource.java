package com.desafios.desafio_01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafios.desafio_01.entities.Regiao;
import com.desafios.desafio_01.services.RegiaoService;

@RestController
@RequestMapping(value = "/regioes")
public class RegiaoResource {
	
	@Autowired 
	private RegiaoService service;
	
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
}
