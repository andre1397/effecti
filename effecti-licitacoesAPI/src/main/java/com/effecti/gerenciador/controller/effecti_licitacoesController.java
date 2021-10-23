package com.effecti.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effecti.gerenciador.entities.LicitacaoEntity;
import com.effecti.gerenciador.repository.LicitacoesRepository;
import com.effecti.gerenciador.services.LicitacoesServices;

@RestController
@RequestMapping(value = "api/effecti")
public class effecti_licitacoesController {
	
	@Autowired
	private LicitacoesRepository licitacoesRepository;
	
	@Autowired
	private LicitacoesServices licitacaoServices;
	
	@GetMapping("/extrair")
	public void extrair() throws IOException {
		licitacaoServices.salvaLicitacoes();
		System.out.println("Dados extraídos e salvos");
	}
		
	@GetMapping("/lista")
	public List<LicitacaoEntity> listar() throws IOException {
		System.out.println(licitacoesRepository.findAll());
		return licitacoesRepository.findAll();
	}
}
