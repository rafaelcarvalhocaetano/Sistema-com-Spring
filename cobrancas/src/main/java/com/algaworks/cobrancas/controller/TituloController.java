package com.algaworks.cobrancas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobrancas.model.StatusTitulo;
import com.algaworks.cobrancas.model.Titulo;
import com.algaworks.cobrancas.repository.Titulos;

	
@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@Autowired
	private Titulos titulos;

	
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
		//System.out.println("Salvo com sucesso "+titulo.getDescricao());
		titulos.save(titulo);
		//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
		attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
		return "redirect:/titulos/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
		//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
		return mv; 
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		titulos.delete(codigo);
		
		return "redirect:/titulos";
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
	//----------------------------------------------
private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@Autowired
	private Titulos titulos;

	
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
		//System.out.println("Salvo com sucesso "+titulo.getDescricao());
		titulos.save(titulo);
		//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
		attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
		return "redirect:/titulos/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
		//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
		return mv; 
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		titulos.delete(codigo);
		
		return "redirect:/titulos";
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
	//---------------------------------
private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@Autowired
	private Titulos titulos;

	
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
		//System.out.println("Salvo com sucesso "+titulo.getDescricao());
		titulos.save(titulo);
		//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
		attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
		return "redirect:/titulos/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
		//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
		return mv; 
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		titulos.delete(codigo);
		
		return "redirect:/titulos";
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
	//---------------------------------
	private static final String CADASTRO_VIEW = "CadastroTitulo";
		
		@Autowired
		private Titulos titulos;

		
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
			//System.out.println("Salvo com sucesso "+titulo.getDescricao());
			titulos.save(titulo);
			//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
			attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
			return "redirect:/titulos/novo";
		}
		
		@RequestMapping("{codigo}")
		public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
			//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
			ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
			mv.addObject(titulo);
			return mv;
		}
		
		@RequestMapping
		public ModelAndView pesquisar(){
			List<Titulo> todosTitulos = titulos.findAll();
			ModelAndView mv = new ModelAndView("PesquisaTitulos");
			mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
			return mv; 
		}
		
		@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
		public String excluir(@PathVariable Long codigo){
			titulos.delete(codigo);
			
			return "redirect:/titulos";
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
		//---------------------------------
		private static final String CADASTRO_VIEW = "CadastroTitulo";
			
			@Autowired
			private Titulos titulos;

			
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
				//System.out.println("Salvo com sucesso "+titulo.getDescricao());
				titulos.save(titulo);
				//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
				attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
				return "redirect:/titulos/novo";
			}
			
			@RequestMapping("{codigo}")
			public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
				//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
				ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
				mv.addObject(titulo);
				return mv;
			}
			
			@RequestMapping
			public ModelAndView pesquisar(){
				List<Titulo> todosTitulos = titulos.findAll();
				ModelAndView mv = new ModelAndView("PesquisaTitulos");
				mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
				return mv; 
			}
			
			@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
			public String excluir(@PathVariable Long codigo){
				titulos.delete(codigo);
				
				return "redirect:/titulos";
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
			//---------------------------------
			private static final String CADASTRO_VIEW = "CadastroTitulo";
				
				@Autowired
				private Titulos titulos;

				
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
					//System.out.println("Salvo com sucesso "+titulo.getDescricao());
					titulos.save(titulo);
					//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
					attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
					return "redirect:/titulos/novo";
				}
				
				@RequestMapping("{codigo}")
				public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
					//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
					ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
					mv.addObject(titulo);
					return mv;
				}
				
				@RequestMapping
				public ModelAndView pesquisar(){
					List<Titulo> todosTitulos = titulos.findAll();
					ModelAndView mv = new ModelAndView("PesquisaTitulos");
					mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
					return mv; 
				}
				
				@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
				public String excluir(@PathVariable Long codigo){
					titulos.delete(codigo);
					
					return "redirect:/titulos";
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
				//---------------------------------
				private static final String CADASTRO_VIEW = "CadastroTitulo";
					
					@Autowired
					private Titulos titulos;

					
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
						//System.out.println("Salvo com sucesso "+titulo.getDescricao());
						titulos.save(titulo);
						//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
						attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
						return "redirect:/titulos/novo";
					}
					
					@RequestMapping("{codigo}")
					public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
						//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
						ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
						mv.addObject(titulo);
						return mv;
					}
					
					@RequestMapping
					public ModelAndView pesquisar(){
						List<Titulo> todosTitulos = titulos.findAll();
						ModelAndView mv = new ModelAndView("PesquisaTitulos");
						mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
						return mv; 
					}
					
					@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
					public String excluir(@PathVariable Long codigo){
						titulos.delete(codigo);
						
						return "redirect:/titulos";
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
					//---------------------------------
					private static final String CADASTRO_VIEW = "CadastroTitulo";
						
						@Autowired
						private Titulos titulos;

						
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
							//System.out.println("Salvo com sucesso "+titulo.getDescricao());
							titulos.save(titulo);
							//ModelAndView mv2 =  new ModelAndView("redirect:/titulos/novo"); //cria a variavel mensagem que está no html através do themeleaf
							attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");
							return "redirect:/titulos/novo";
						}
						
						@RequestMapping("{codigo}")
						public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
							//Titulo titulo = titulos.findOne(codigo); //recupera o id do titulo do banco de dados que está no model
							ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
							mv.addObject(titulo);
							return mv;
						}
						
						@RequestMapping
						public ModelAndView pesquisar(){
							List<Titulo> todosTitulos = titulos.findAll();
							ModelAndView mv = new ModelAndView("PesquisaTitulos");
							mv.addObject("titulos", todosTitulos); //disponibiliza uma variavel titulos para ser usado no html listando os itens
							return mv; 
						}
						
						@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
						public String excluir(@PathVariable Long codigo){
							titulos.delete(codigo);
							
							return "redirect:/titulos";
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
