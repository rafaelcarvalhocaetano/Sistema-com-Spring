package com.algaworks.cobrancas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.algaworks.cobrancas.model.Titulo;

	
@Controller
@RequestMapping("/titulos")
public class TituloController {

	
	//@RequestMapping("/titulos/novo") --> após ter adicionado o /titulos
	@RequestMapping("/novo")
	public String novo(){
		return "CadastroTitulo";
	}
	
	//@RequestMapping(value = "/titulos", method= RequestMethod.POST) --> após ter adicionado o /titulos
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Titulo titulo) {
		System.out.println(">>> " + titulo.getDescricao());
		
		return "CadastroTitulo";
	}

}
