package com.desafios.desafio_01.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafios.desafio_01.entities.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

	// List <Regiao> resumao();
}
