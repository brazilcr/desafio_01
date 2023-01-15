package com.desafios.desafio_01.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.desafio_01.entities.Agente;

@RestController
@RequestMapping(value = "/agentes")
public class AgenteResource {
	
	@GetMapping
	public ResponseEntity<Agente> findAll() {
		Agente a = new Agente(1L, "Maria", "");
		return ResponseEntity.ok().body(a);
	}
}
