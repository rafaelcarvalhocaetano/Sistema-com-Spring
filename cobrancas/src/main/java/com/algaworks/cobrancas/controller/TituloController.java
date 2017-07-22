package com.algaworks.cobrancas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobrancas.model.StatusTitulo;
import com.algaworks.cobrancas.model.Titulo;
import com.algaworks.cobrancas.repository.Titulos;
import com.algaworks.cobrancas.repository.filter.TituloFilter;
import com.algaworks.cobrancas.service.CadastroTituloService;

	
@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@Autowired
	private Titulos titulos;
	
	@Autowired
	private CadastroTituloService cadastroTituloService; //injeção de dep. da classe service

	
	//@RequestMapping("/titulos/novo") --> após ter adicionado o /titulos
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		//mv.addObject("todoStatusTitulo",StatusTitulo.values());
		mv.addObject(new Titulo());
		return mv;
	}
	
	//@RequestMapping(value = "/titulos", method= RequestMethod.POST) --> após ter adicionado o /titulos
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) { //O @Validated exige o preenchimento do campo
		//ModelAndView mv = new ModelAndView(); //chama a pagina CadastroTitulo através do mv
		
		if(errors.hasErrors()){
			return CADASTRO_VIEW;
		}
		try {
			
			//System.out.println("Salvo com sucesso "+titulo.getDescricao());
			cadastroTituloService.salvar(titulo);
			//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
			attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
			return "redirect:/titulos/novo";
			
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", e.getMessage());
			return CADASTRO_VIEW;
		}
		
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
		//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@RequestAttribute("filtro") TituloFilter filtro){
		
		//List<Titulo> todosTitulos = titulos.findAll();
		
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		
		List<Titulo> todosTitulos = titulos.findByDescricaoContaining(descricao);
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
		return mv; 
		/*
		 * @RequestParam(defaultValue = "%") String descricao
		 * Busca um valor
		 * /
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		cadastroTituloService.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso !");
		return "redirect:/titulos";
	}
	
	
	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo){
		
		return cadastroTituloService.receber(codigo);
				
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
