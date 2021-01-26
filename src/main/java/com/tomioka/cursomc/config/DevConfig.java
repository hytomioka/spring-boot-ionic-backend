package com.tomioka.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tomioka.cursomc.services.DBService;

@Configuration
@Profile("dev") // todos os "beans" serao executados somente qnd o perfil ativo estiver em
					// "dev"
public class DevConfig {

	@Autowired
	DBService dbService;

	// retorna o valor armezanado no arquivo application-dev.properties
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateDataBase();
		return true;
	}
}
