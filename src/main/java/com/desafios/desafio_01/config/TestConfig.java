package com.desafios.desafio_01.config;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
		DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate  date1 = LocalDate.parse("2022-12-01");
		Agente a1 = new Agente(null, "O Lord", date1 );
		LocalDate  date2 = LocalDate.parse("2022-12-12");
		Agente a2 = new Agente(null, "Francisco", date2 );
		LocalDate  date3 = LocalDate.parse("2022-12-21");
		Agente a3 = new Agente(null, "Raimundo", date3 );
		
		agenteRepository.saveAll(Arrays.asList(a1, a2, a3));

		Regiao r1 = new Regiao(null, "Sul", 1.32221, 1.43333, 90.5);
		Regiao r2 = new Regiao(null, "Norte", 2.22332, 2.34442, 2190.0);
		Regiao r3 = new Regiao(null, "Sudeste", 3.223311,3.322345, 1250.0);
		regiaoRepository.saveAll(Arrays.asList(r1, r2, r3));
	}

}
