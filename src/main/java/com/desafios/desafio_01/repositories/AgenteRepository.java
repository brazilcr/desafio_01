package com.desafios.desafio_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafios.desafio_01.entities.Agente;

public interface AgenteRepository extends JpaRepository<Agente, Long>  {
	
}
