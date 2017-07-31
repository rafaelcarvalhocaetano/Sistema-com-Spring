package com.teste.rcc.cobranca.controller;


//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


	
@Controller
@RequestMapping("/titulos")
public class TesteController {
	

	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("Layout");
		//mv.addObject("todoStatusTitulo",StatusTitulo.values());
		return mv;
	}
	
}