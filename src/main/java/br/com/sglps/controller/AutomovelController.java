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

import br.com.sglps.model.Automovel;
import br.com.sglps.service.InterfaceAutomovelService;

@Controller
@RequestMapping(value = "/automovel/")
public class AutomovelController {

	@Autowired
	InterfaceAutomovelService automovelService;

	/********************************************************************************/

	@RequestMapping(value = { "/gerencia-all-automovel" }, method = RequestMethod.GET)
	public ModelAndView homePrincipal() {

		ModelAndView model = new ModelAndView("automovel/gerencia-all-automovel");

		List<Automovel> listaAutomovel = automovelService.buscarTodosAutomoveis();
		model.addObject("listAutomovel", listaAutomovel);

		return model;
	}

	/********************************************************************************/

	@RequestMapping(value = { "/cadastro-automovel" }, method = RequestMethod.GET)
	public ModelAndView add(Model atributos) {

		ModelAndView model = new ModelAndView("automovel/cadastro-automovel");

		Automovel automovel = new Automovel();

		model.addObject("automovel", automovel);
		
		populateDefaultModel(atributos);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/salvarAutomovel", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("automovel") @Valid Automovel automovel, BindingResult result,
			RedirectAttributes attributes, Model dropd) {

		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			
			populateDefaultModel(dropd);
			return "automovel/cadastro-automovel";

		} else {

			automovelService.inserirAutomovel(automovel);

			attributes.addFlashAttribute("mensagemOk", "AUTOMÓVEL SALVO COM SUCESSO");

			return ("redirect:/automovel/gerencia-all-automovel");

		}

	}

	/********************************************************************************/

	@RequestMapping(value = { "/updateAutomovel/{idAutomovel}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idAutomovel") Integer idAutomovel, Model dropd) {

		ModelAndView model = new ModelAndView("automovel/atualiza-automovel");

		Automovel automovel = automovelService.buscarAutomovelPorId(idAutomovel);

		model.addObject("automovel", automovel);
		
		populateDefaultModel(dropd);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarAutomovel", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("automovel") @Valid Automovel automovel, BindingResult result,
			RedirectAttributes attributes, Model dropd) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			populateDefaultModel(dropd);
			return "automovel/atualiza-automovel";

		} else {

			automovelService.atualizarAutomovel(automovel);
			attributes.addFlashAttribute("mensagemOk", "AUTOMÓVEL ATUALIZADO COM SUCESSO");
			attributes.addFlashAttribute("idViewAtualiza",automovel.getIdAutomovel());

			return ("redirect:/automovel/gerencia-all-automovel");
		}

	}
	
	/********************************************************************************/


	private void populateDefaultModel(Model modelDropDown) {

		Map<String, String> statusAutomovel = new LinkedHashMap<String, String>();
		statusAutomovel.put("", "Selecione o status");
		statusAutomovel.put("Disponível", "Disponível");
		statusAutomovel.put("Indisponível", "Indisponível");
		

		modelDropDown.addAttribute("statusAutomovelList", statusAutomovel);

		

	}

}
