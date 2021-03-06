package com.effecti.gerenciador.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effecti.gerenciador.entities.LicitacaoEntity;
import com.effecti.gerenciador.exception.EffectiException;
import com.effecti.gerenciador.repository.LicitacoesRepository;
import com.effecti.gerenciador.webScrapping.WebScrapping;

@Service
public class LicitacoesServices {
	
	@Autowired
	LicitacoesRepository licitacoesRepository;
	
	public void limpaBD() throws EffectiException{
		System.out.println("Iniciando limpeza dos dados do BD...");
		licitacoesRepository.deleteAll();
		System.out.println("Limpeza completa");
	}
	
	public void salvaLicitacoes() throws EffectiException, IOException {
		List<LicitacaoEntity> listaLicitacoes = WebScrapping.extrairDados();
		for (LicitacaoEntity licitacao:listaLicitacoes) {
			System.out.println("Salvando licitação: " + licitacao.getLicitacao());
			licitacoesRepository.save(licitacao);
		}
		System.out.println("Todas as licitações salvas");
	}
	
	public List<LicitacaoEntity> listaLicitacoes() throws EffectiException{
		System.out.println("Listando licitações...");
		System.out.println("Listagem completa");
		return licitacoesRepository.findAll();
	}
}
