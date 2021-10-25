package com.effecti.gerenciador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.effecti.gerenciador.exception.EffectiException;

@SpringBootApplication
@Configuration
public class EffectiLicitacoesGerenciador {

	private static Logger logger = LoggerFactory.getLogger(EffectiException.class);
	
	public static void main(String[] args) {
			SpringApplication.run(EffectiLicitacoesGerenciador.class, args);
	}

}
