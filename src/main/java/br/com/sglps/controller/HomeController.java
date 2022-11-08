package br.com.sglps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	
	//Define a url que quando for requisitada chamara o metodo no caso /home/principal ou /home/ ou /home
		//Note que não é obrigado apenas uma url, pode-se mapear varias para o mesmo metodo 
		@RequestMapping( value = { "/dashboard" }) 
		public ModelAndView homePrincipal(){
			 //Retorna a view que deve ser chamada, no caso principal (principal.jsp) que esta dentro da pasta /home
			return new ModelAndView("home/dashboardsglps");
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
