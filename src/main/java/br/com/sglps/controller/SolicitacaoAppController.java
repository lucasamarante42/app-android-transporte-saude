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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sglps.model.Agendamento;
import br.com.sglps.model.SolicitacaoApp;
import br.com.sglps.service.InterfaceAgendamentoService;
import br.com.sglps.service.InterfaceAutomovelService;
import br.com.sglps.service.InterfaceDestinoService;
import br.com.sglps.service.InterfaceMotoristaService;
//import br.com.sglps.service.InterfacePacienteService;
import br.com.sglps.service.InterfaceRotaService;
import br.com.sglps.service.InterfaceSolicitacaoAppService;

@Controller
@SessionAttributes("solicitacao")
public class SolicitacaoAppController {
	
	@Autowired
	private InterfaceSolicitacaoAppService solicitacaoAppService;
	
	@Autowired 
	private InterfaceAgendamentoService agendamentoService;
	
	//@Autowired 
	//private InterfacePacienteService pacienteService; 
	
	@Autowired 
	private InterfaceDestinoService destinoService;
	
	@Autowired 
	private InterfaceMotoristaService motoristaService;
	
	@Autowired 
	private InterfaceAutomovelService automovelService;
	
	@Autowired 
	private InterfaceRotaService rotaService;
		
	
	
	@RequestMapping(value = { "/requisicoesviaapp/solicitacao-app" }, method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView model = new ModelAndView("requisicoesviaapp/solicitacao-app");

		List<SolicitacaoApp> listaSolicitacao = solicitacaoAppService.buscarTodasSolicitacoesApp();
		model.addObject("consultaSolicitacoes", listaSolicitacao);
		
		Agendamento agendamento = new Agendamento();

		model.addObject("agendamento", agendamento);

		return model;

	}
	
/********************************************************************************/
	
	@RequestMapping(value = { "/agendamento/viaAppCadastroAgendamento/{idSolicitacaoPacApp}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idSolicitacaoPacApp") Integer idSolicitacaoPacApp, 
			Model atributos) {

		ModelAndView model = new ModelAndView("agendamento/viaapp-cadastro-agendamento");

		SolicitacaoApp solicitacao = solicitacaoAppService.buscarSolicitacaoPorId(idSolicitacaoPacApp);
		
		model.addObject("solicitacao", solicitacao);
				
		atributos.addAttribute("destinos", destinoService.buscarTodosDestinos());
		atributos.addAttribute("motoristas", motoristaService.disponivelBuscarTodosMotoristas());
		atributos.addAttribute("automoveis", automovelService.disponivelBuscarTodosAutomoveis());
		atributos.addAttribute("rotas", rotaService.buscarTodasRotas());
		
		
		Agendamento agendamento = new Agendamento();
		
		model.addObject("agendamento", agendamento);
		
		populateDefaultModel(atributos);
		
		return model;

	}
	
	
/********************************************************************************/
	
	@RequestMapping(value = "/agendamento/viaAppsalvarAgendamento", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("agendamento") @Valid Agendamento agendamento, 
			BindingResult result,
			RedirectAttributes attributes, Model atributos,
			@ModelAttribute("solicitacao") SolicitacaoApp solicitacao ) {
						
		ModelAndView model = new ModelAndView();
		model.addObject("solicitacao", solicitacao);
		
		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			
			atributos.addAttribute("destinos", destinoService.buscarTodosDestinos());
			atributos.addAttribute("motoristas", motoristaService.disponivelBuscarTodosMotoristas());
			atributos.addAttribute("automoveis", automovelService.disponivelBuscarTodosAutomoveis());
			atributos.addAttribute("rotas", rotaService.buscarTodasRotas());
			
			populateDefaultModel(atributos);
			
			//model.addObject("solicitacao", solicitacao);
			//System.out.println("Vendo aqui !!" + solicitacao.getIdDestinoAgendamento());
			
			//guarda ids com get compara na view
			atributos.addAttribute("idDestinoAgendamentoGet",agendamento.getIdDestinoAgendamento());
			atributos.addAttribute("idMotoristaAgendamentoGet",agendamento.getIdMotoristaAgendamento());
			atributos.addAttribute("idAutomovelAgendamentoGet",agendamento.getIdAutomovelAgendamento());
			atributos.addAttribute("idRotaAgendamentoGet",agendamento.getIdRotaAgendamento());
			
			return "agendamento/viaapp-cadastro-agendamento";
			//"agendamento/viaapp-cadastro-agendamento";

		} else {

			agendamentoService.inserirAgendamento(agendamento);	
			solicitacaoAppService.atualizarStatusSolicitacao(solicitacao);
			
			
			attributes.addFlashAttribute("mensagemOk", "AGENDAMENTO SALVO COM SUCESSO");
			//limpar atributo de sessao
			return ("redirect:/agendamento/gerencia-all-agendamento");

		}

	}
	
	/********************************************************************************/
	

	private void populateDefaultModel(Model modelDropDown) {

		Map<String, String> necessidadeAcompanhanteAgendamento = new LinkedHashMap<String, String>();
		necessidadeAcompanhanteAgendamento.put("", 
				"Selecione necessidade de acompanhante");
		necessidadeAcompanhanteAgendamento.put("Não", "Não");
		necessidadeAcompanhanteAgendamento.put("Sim", "Sim");

		modelDropDown.addAttribute("necessidadeAcompanhanteAgendamentoList", necessidadeAcompanhanteAgendamento);

		/******************************************/
		
		Map<String, String> statusAgendamento = new LinkedHashMap<String, String>();
		statusAgendamento.put("", "Selecione o status");
		statusAgendamento.put("Não aprovado", "Não aprovado");
		statusAgendamento.put("Aprovado", "Aprovado");

		modelDropDown.addAttribute("statusAgendamentoList", statusAgendamento);
		
		/******************************************/


	}

}
