package com.effecti.gerenciador.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effecti.gerenciador.entities.LicitacaoEntity;
import com.effecti.gerenciador.repository.LicitacoesRepository;
import com.effecti.gerenciador.webScrapping.WebScrapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LicitacoesServices {
	
	@Autowired
	LicitacoesRepository licitacoesRepository;

	public static void converterToJson(LicitacaoEntity licitacaoEntity) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(licitacaoEntity);
			StringBuilder string = new StringBuilder("Objeto em JSON: ");
			System.out.println(string.append(json));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	public void salvaLicitacoes() throws IOException {//Esse método executa o WebScrapping e então pega os dados que chegaram e vai salvando eles um por um em objetos no repositório
		List<LicitacaoEntity> listaLicitacoes = WebScrapping.extrairDados();
		for (LicitacaoEntity licitacao:listaLicitacoes) {//Percorre a lista toda de Json retornado pelo WebScrapping um por um, é basicamente um forEach
			System.out.println("Salvando licitação: " + licitacao.getLicitacao());
			licitacoesRepository.save(licitacao);
		}
		System.out.println("Acabou");
	}
}
