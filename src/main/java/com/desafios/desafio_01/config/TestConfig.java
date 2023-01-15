package com.desafios.desafio_01.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafios.desafio_01.entities.Agente;
import com.desafios.desafio_01.entities.Regiao;
import com.desafios.desafio_01.repositories.AgenteRepository;
import com.desafios.desafio_01.repositories.RegiaoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AgenteRepository agenteRepository;
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Agente a1 = new Agente(null, "O Lord", "2022-12-01");
		Agente a2 = new Agente(null, "Francisco", "2022-12-01");
		Agente a3 = new Agente(null, "Raimundo", "2022-12-01");
		
		agenteRepository.saveAll(Arrays.asList(a1, a2, a3));

		Regiao r1 = new Regiao(null, 1.32221, 1.43333, 90.5);
		Regiao r2 = new Regiao(null, 2.22332, 2.34442, 2190.0);
		Regiao r3 = new Regiao(null, 3.223311,3.322345, 1250.0);
		regiaoRepository.saveAll(Arrays.asList(r1, r2, r3));
	}

}
