package com.algaworks.cobrancas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobrancas.model.StatusTitulo;
import com.algaworks.cobrancas.model.Titulo;
import com.algaworks.cobrancas.repository.Titulos;

	
@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;

	
	//@RequestMapping("/titulos/novo") --> após ter adicionado o /titulos
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		//mv.addObject("todoStatusTitulo",StatusTitulo.values());
		return mv;
	}
	
	//@RequestMapping(value = "/titulos", method= RequestMethod.POST) --> após ter adicionado o /titulos
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		
		System.out.println("Salvo com sucesso "+titulo.getDescricao());
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo"); //chama a pagina CadastroTitulo através do mv
		mv.addObject("mensagem","Título salvo com sucesso"); //cria a variavel mensagem que está no html através do themeleaf
		
		return mv;
	}
	
	@RequestMapping()
	public String pesquisar(){
		return "PesquisaTitulos";
	}
	
	@ModelAttribute("todoStatusTitulo")
	public List<StatusTitulo> todosTitulos(){
		return Arrays.asList(StatusTitulo.values());
		/*
		 *Este método chama todos os atributos do enum sem a necessidade de duplicar o código no ModelAndView
		 *@ModelAttribute serve para dar um nome ao metodo ao ser chamado no html ou melhor no thymeleaf 
		 * 
		*/
	}

}
