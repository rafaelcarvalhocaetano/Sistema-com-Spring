package com.algaworks.cobrancas.model;

import javax.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Titulo {
	
	
	private Long codigo;
	
	private String descricao;
	
	private Date dataVencimento;
	
	private BigDecimal valor;
	
	private StatusTitulo status;

}
