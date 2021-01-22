package com.tomioka.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomioka.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	// Spring Data gera uma funcao de busca a partir de "find" + "By" + "atributo" 
	Cliente findByEmail(String email);
}
