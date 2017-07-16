package com.teste.cob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TituloController {
	

	@RequestMapping("/titulos/novo")
	public String novo(){
		return "CadastroTitulo";
	}
	
	/*
	@RequestMapping(value = "/titulos", method=RequestMethod.POST)
	public String salvar(Titulo titulo){
		System.out.println(">>>>> teste "+titulo.getDescricao());
		
		return "CadastroTitulo";
	}
	*/
}
