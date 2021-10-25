package com.effecti.gerenciador.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "licitacao")
public class LicitacaoEntity implements Serializable{
	
	private static final long serialVersionUID = 4549464930517745158L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "licitacao")
    private String licitacao;
	@Column(name = "status")
    private String status;
	@Column(name = "localizacao")
    private String localizacao;
    @Column(name = "vigencia")
    private String vigencia;
    @Column(name = "descricao", length = 2000)
    private String descricao;
    @Column(name = "arquivoVisualizar")
    private String arquivoVisualizar = "https://sig.ifsc.edu.br/";
    @Column(name = "arquivoItens")
    private String arquivoItens = "https://sig.ifsc.edu.br/";
    @Column(name = "arquivoBaixar")
    private String arquivoBaixar = "https://sig.ifsc.edu.br/public/";
    
    public LicitacaoEntity(String licitacao, String status, String localizacao, String vigencia, String descricao, String arquivoVisualizar, String arquivoItens, String arquivoBaixar) {
		this.licitacao = licitacao;
		this.status = status;
		this.localizacao = localizacao;
		this.vigencia = vigencia;
		this.descricao = descricao;
		this.arquivoVisualizar = arquivoVisualizar;
		this.arquivoItens = arquivoItens;
		this.arquivoBaixar = arquivoBaixar;
	}

    public LicitacaoEntity() {
    }

	public Long getId() {
		return id;
	}

	public String getLicitacao() {
		return licitacao;
	}

	public void setLicitacao(String licitacao) {
		this.licitacao = licitacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getArquivoVisualizar() {
		return arquivoVisualizar;
	}

	public void setArquivoVisualizar(String arquivoVisualizar) {
		this.arquivoVisualizar += arquivoVisualizar;
	}

	public String getArquivoItens() {
		return arquivoItens;
	}

	public void setArquivoItens(String arquivoItens) {
		this.arquivoItens += arquivoItens;
	}

	public String getArquivoBaixar() {
		return arquivoBaixar;
	}

	public void setArquivoBaixar(String arquivoBaixar) {
		this.arquivoBaixar += arquivoBaixar;
	}
    
}
