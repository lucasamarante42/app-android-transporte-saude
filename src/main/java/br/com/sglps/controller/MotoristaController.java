package br.com.sglps.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sglps.model.Motorista;
import br.com.sglps.service.InterfaceMotoristaService;

@Controller
@RequestMapping(value = "/motorista/")
public class MotoristaController {

	@Autowired
	InterfaceMotoristaService motoristaService;

	/********************************************************************************/

	@RequestMapping(value = { "/gerencia-all-motorista" }, method = RequestMethod.GET)
	public ModelAndView homePrincipal() {

		ModelAndView model = new ModelAndView("motorista/gerencia-all-motorista");

		List<Motorista> listaMotorista = motoristaService.buscarTodosMotoristas();
		model.addObject("listMotorista", listaMotorista);

		return model;

	}
	
	/********************************************************************************/
	
	@RequestMapping(value = { "/cadastro-motorista" }, method = RequestMethod.GET)
	public ModelAndView add(Model atributos) {

		ModelAndView model = new ModelAndView("motorista/cadastro-motorista");

		Motorista motorista = new Motorista();
		
		model.addObject("motorista", motorista);
		
		populateDefaultModel(atributos);

		return model;

	}

	/********************************************************************************/
	
	@RequestMapping(value = "/salvarMotorista", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("motorista") @Valid Motorista motorista, BindingResult result,
			RedirectAttributes attributes, Model dropd) {

		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			
			populateDefaultModel(dropd);
			return "motorista/cadastro-motorista";

		} else {

			motoristaService.inserirMotorista(motorista);			

			attributes.addFlashAttribute("mensagemOk", "MOTORISTA SALVO COM SUCESSO");

			return ("redirect:/motorista/gerencia-all-motorista");

		}

	}

	/********************************************************************************/

	@RequestMapping(value = { "/updateMotorista/{idMotorista}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idMotorista") Integer idMotorista, Model dropd) {

		ModelAndView model = new ModelAndView("motorista/atualiza-motorista");

		Motorista motorista = motoristaService.buscarMotoristaPorId(idMotorista);
		
		model.addObject("motorista", motorista);
		
		populateDefaultModel(dropd);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarMotorista", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("motorista") @Valid Motorista motorista, BindingResult result,
			RedirectAttributes attributes, Model dropd) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			populateDefaultModel(dropd);
			return "motorista/atualiza-motorista";

		} else {

			motoristaService.atualizarMotorista(motorista);
						
			attributes.addFlashAttribute("mensagemOk", "MOTORISTA ATUALIZADO COM SUCESSO");
			attributes.addFlashAttribute("idViewAtualiza",motorista.getIdMotorista());
			return ("redirect:/motorista/gerencia-all-motorista");
		}

	}
	
		
	/********************************************************************************/


	private void populateDefaultModel(Model modelDropDown) {

		Map<String, String> statusMotorista = new LinkedHashMap<String, String>();
		statusMotorista.put("", "Selecione o status");
		statusMotorista.put("Disponível", "Disponível");
		statusMotorista.put("Indisponível", "Indisponível");

		modelDropDown.addAttribute("statusMotoristaList", statusMotorista);

		

	}
	
	
	
	
	
	
	

}
