package com.teste.rcc.cobranca.controller;


//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

	
@Controller
public class TituloController {
	

	@RequestMapping("titulos/novo")
	public String novo(){
		return "Layout";
	}
	
}