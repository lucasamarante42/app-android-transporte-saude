package br.com.sglps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sglps.model.Rota;
import br.com.sglps.service.InterfaceRotaService;





@Controller
@RequestMapping(value = "/rota/")
public class RotaController {
	
	@Autowired
	InterfaceRotaService rotaService;
	
	
	/********************************************************************************/
	
	
	@RequestMapping( value = { "/gerencia-all-rota" }, method = RequestMethod.GET ) 
	public ModelAndView homePrincipal(){
		
		ModelAndView model = new ModelAndView("rota/gerencia-all-rota");

		List<Rota> listaRota = rotaService.buscarTodasRotas();
		model.addObject("listRota", listaRota);

		return model;
		
	}
	
	/********************************************************************************/
	
	@RequestMapping(value = { "/cadastro-rota" }, method = RequestMethod.GET)
	public ModelAndView add() {

		ModelAndView model = new ModelAndView("rota/cadastro-rota");

		Rota rota = new Rota();
		
		model.addObject("rota", rota);

		return model;

	}

	/********************************************************************************/
	
	@RequestMapping(value = "/salvarRota", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("rota") @Valid Rota rota, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			return "rota/cadastro-rota";

		} else {

			rotaService.inserirRota(rota);	

			attributes.addFlashAttribute("mensagemOk", "ROTA SALVA COM SUCESSO");

			return ("redirect:/rota/gerencia-all-rota");

		}

	}

	/********************************************************************************/
	
	@RequestMapping(value = { "/updateRota/{idRota}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idRota") Integer idRota) {

		ModelAndView model = new ModelAndView("rota/atualiza-rota");

		Rota rota = rotaService.buscarRotaPorId(idRota);
		
		model.addObject("rota", rota);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarRota", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("rota") @Valid Rota rota, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			return "rota/atualiza-rota";

		} else {

			rotaService.atualizarRota(rota);
						
			attributes.addFlashAttribute("mensagemOk", "ROTA ATUALIZADA COM SUCESSO");
			attributes.addFlashAttribute("idViewAtualiza",rota.getIdRota());
			return ("redirect:/rota/gerencia-all-rota");
		}

	}
	
	
	
	

}
