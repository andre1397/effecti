package com.effecti.gerenciador.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EffectiException extends Exception{
	private static final long serialVersionUID = -2900153898205209548L;
	private String mensagem;
	private Exception exception;
	
	private static Logger logger = LoggerFactory.getLogger(EffectiException.class);
	
	public EffectiException() {
		this(null, null);
	}

	public EffectiException(String mensagem, Exception exception) {
		super(mensagem, exception);
		this.mensagem = mensagem;
		this.exception = exception;

		logger.error(mensagem);
		logger.error(exception.toString());
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
