package br.com.sglps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sglps.model.Destino;
import br.com.sglps.service.InterfaceDestinoService;

@Controller
@RequestMapping(value = "/destino/")
public class DestinoController {
	
	
	@Autowired
	InterfaceDestinoService destinoService;
	
	/********************************************************************************/
	
	
	@RequestMapping( value = { "/gerencia-all-destino" }, method = RequestMethod.GET) 
	public ModelAndView homePrincipal(){
		
		ModelAndView model = new ModelAndView("destino/gerencia-all-destino");
		
		List<Destino> listaDestino = destinoService.buscarTodosDestinos();
		model.addObject("listDestino", listaDestino);
		
		return model;
			 
			
	}
	
	
	/********************************************************************************/

	@RequestMapping(value = { "/cadastro-destino" }, method = RequestMethod.GET)
	public ModelAndView add() {

		ModelAndView model = new ModelAndView("destino/cadastro-destino");

		Destino destino = new Destino();

		model.addObject("destino", destino);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/salvarDestino", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("destino") @Valid Destino destino, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			return "destino/cadastro-destino";

		} else {

			destinoService.inserirDestino(destino);
			

			attributes.addFlashAttribute("mensagemOk", "DESTINO SALVO COM SUCESSO");

			return ("redirect:/destino/gerencia-all-destino");

		}

	}

	/********************************************************************************/

	@RequestMapping(value = { "/updateDestino/{idDestino}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idDestino") Integer idDestino) {

		ModelAndView model = new ModelAndView("destino/atualiza-destino");

		Destino destino = destinoService.buscarDestinoPorId(idDestino);

		model.addObject("destino", destino);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarDestino", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("destino") @Valid Destino destino, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			return "destino/atualiza-destino";

		} else {

			destinoService.atualizarDestino(destino);
			
			attributes.addFlashAttribute("mensagemOk", "DESTINO ATUALIZADO COM SUCESSO");
			attributes.addFlashAttribute("idViewAtualiza",destino.getIdDestino());
			return ("redirect:/destino/gerencia-all-destino");
		}

	}

	
	
	
	
	
	
	

}
