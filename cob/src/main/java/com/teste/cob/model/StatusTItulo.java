package com.teste.cob.model;

public enum StatusTItulo {
	
	
	PENDENTE("Pendente"), RECEBIDO("Recebido");
	
	private String descricao;
	
	
	private StatusTItulo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
