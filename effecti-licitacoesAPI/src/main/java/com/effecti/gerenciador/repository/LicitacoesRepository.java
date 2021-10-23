package com.effecti.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effecti.gerenciador.entities.LicitacaoEntity;

@Repository
public interface LicitacoesRepository extends JpaRepository<LicitacaoEntity, Long>{
	LicitacaoEntity findByLicitacao(String licitacao);
}
