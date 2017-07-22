package com.algaworks.cobrancas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobrancas.model.Titulo;
import com.algaworks.cobrancas.repository.Titulos;

@Service
public class CadastroTituloService {
	
	
	@Autowired
	private Titulos titulos;
	
	
	public void salvar(Titulo titulo){
		try {
			
			titulos.save(titulo);
			
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data errado");
		}
		
	}
	public void excluir(Long codigo){
		titulos.delete(codigo);
	}

}
