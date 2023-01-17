package com.desafios.desafio_01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafios.desafio_01.entities.Agente;
import com.desafios.desafio_01.services.AgenteService;

@RestController
@RequestMapping(value = "/agentes")
public class AgenteResource {
	
	@Autowired 
	private AgenteService service;
	
	@GetMapping
	public ResponseEntity<List<Agente>> findAll() {
		List<Agente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Agente> findById(@PathVariable Long id) {
		Agente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	/*@GetMapping(value = "/goupload")
	public ResponseEntity<String> getDoupload() {
		System.out.println("entrei aqui 2");
		String message = "Successfully uploaded!";
		return ResponseEntity.status(HttpStatus.OK).body(message);
	} */
}
