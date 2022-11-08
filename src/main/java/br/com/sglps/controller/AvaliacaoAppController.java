package br.com.sglps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sglps.model.AvaliacaoApp;
import br.com.sglps.service.InterfaceAvaliacaoAppService;

@Controller
@RequestMapping(value = "/requisicoesviaapp/")
public class AvaliacaoAppController {

	@Autowired
	InterfaceAvaliacaoAppService avaliacaoAppService;

	@RequestMapping(value = { "/avaliacao-app" }, method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView model = new ModelAndView("requisicoesviaapp/avaliacao-app");

		List<AvaliacaoApp> listaAvaliacao = avaliacaoAppService.buscarTodasAvaliacoesApp();
		model.addObject("consultaAvaliacao", listaAvaliacao);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = { "/atualizaVisualizacaoAvaliacao/{idAvaliacaoPac}" }, method = RequestMethod.GET)
	public String update(@PathVariable("idAvaliacaoPac") Integer idAvaliacaoPac) {

		ModelAndView model = new ModelAndView("requisicoesviaapp/avaliacao-app");

		AvaliacaoApp avaliacao = avaliacaoAppService.buscaStatusAvaliacaoPorId(idAvaliacaoPac);

		model.addObject("avaliacao", avaliacao);

		avaliacaoAppService.atualizarStatusAvaliacao(avaliacao);

		return ("redirect:/requisicoesviaapp/avaliacao-app");

	}

}
