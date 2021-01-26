package com.tomioka.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tomioka.cursomc.services.DBService;

@Configuration
@Profile("test") // todos os "beans" serao executados somente qnd o perfil ativo estiver em
					// "test"
public class TestConfig {

	@Autowired
	DBService dbService;

	@Bean
	public void instantiateDataBase() throws ParseException {
		dbService.instantiateDataBase();
	}
}
