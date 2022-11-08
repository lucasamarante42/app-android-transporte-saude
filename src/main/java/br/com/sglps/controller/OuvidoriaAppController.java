package br.com.sglps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sglps.model.OuvidoriaApp;
import br.com.sglps.service.InterfaceOuvidoriaAppService;


@Controller
@RequestMapping(value = "/requisicoesviaapp/")
public class OuvidoriaAppController {
	
	@Autowired
	InterfaceOuvidoriaAppService ouvidoriaAppService;
	
	@RequestMapping(value = { "/ouvidoria-app" }, method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView model = new ModelAndView("requisicoesviaapp/ouvidoria-app");

		List<OuvidoriaApp> listaOuvidoria = ouvidoriaAppService.buscarTodasOuvidoriasApp();
		model.addObject("consultaOuvidoria", listaOuvidoria);

		return model;

	}	
	
	/********************************************************************************/
	
	@RequestMapping(value = { "/atualizaVisualizacaoOuvidoria/{idOuvidoriaPac}" }, method = RequestMethod.GET)
	public String update(@PathVariable("idOuvidoriaPac") Integer idOuvidoriaPac, Model dropd) {

		ModelAndView model = new ModelAndView("requisicoesviaapp/ouvidoria-app");
		
		OuvidoriaApp ouvidoria = ouvidoriaAppService.buscaStatusOuvidoriaPorId(idOuvidoriaPac);

		model.addObject("ouvidoria", ouvidoria);
		
		ouvidoriaAppService.atualizarStatusOuvidoria(ouvidoria);

		return ("redirect:/requisicoesviaapp/ouvidoria-app");

	}
	
	
	
	
	
	
	

}
