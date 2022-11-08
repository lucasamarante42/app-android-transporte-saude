package br.com.sglps.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sglps.model.Agendamento;
import br.com.sglps.model.Automovel;
import br.com.sglps.model.Destino;
import br.com.sglps.service.*;

@Controller
@RequestMapping(value = "/agendamento/")
public class AgendamentoController {

	@Autowired
	private InterfaceAgendamentoService agendamentoService;

	@Autowired
	private InterfacePacienteService pacienteService;

	@Autowired
	private InterfaceDestinoService destinoService;

	@Autowired
	private InterfaceMotoristaService motoristaService;

	@Autowired
	private InterfaceAutomovelService automovelService;

	@Autowired
	private InterfaceRotaService rotaService;
	
	//@Autowired
	//@Qualifier("dropdownValidator")
	// private Validator validator;

	     
	//@InitBinder
	//private void initBinder(WebDataBinder binder) {
	//    binder.setValidator(validator);
	//  }

	/********************************************************************************/

	@RequestMapping(value = { "/gerencia-all-agendamento" }, method = RequestMethod.GET)
	public ModelAndView homePrincipal() {

		ModelAndView model = new ModelAndView("agendamento/gerencia-all-agendamento");

		//try {

			List<Agendamento> listaAgendamento = agendamentoService.buscarTodosAgendamentos();
			model.addObject("listAgendamento", listaAgendamento);

			return model;

	//	} catch (Exception ex) {
	//		return new ModelAndView("errors/error-indisponivel");
	//	}

	}

	/********************************************************************************/

	@RequestMapping(value = { "/cadastro-agendamento" }, method = RequestMethod.GET)
	public ModelAndView add(Model atributos) {

		ModelAndView model = new ModelAndView("agendamento/cadastro-agendamento");

		Agendamento agendamento = new Agendamento();

		model.addObject("agendamento", agendamento);
		
		

		// atributos.addAttribute("pacientes",
		// pacienteService.buscarTodosPacientes());
		atributos.addAttribute("destinos", destinoService.buscarTodosDestinos());
		atributos.addAttribute("motoristas", motoristaService.disponivelBuscarTodosMotoristas());
		atributos.addAttribute("automoveis", automovelService.disponivelBuscarTodosAutomoveis());
		atributos.addAttribute("rotas", rotaService.buscarTodasRotas());
		
		populateDefaultModel(atributos);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/salvarAgendamento", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("agendamento") @Valid Agendamento agendamento, BindingResult result,
			RedirectAttributes attributes, Model dropd, Model atributos) {

		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			
			atributos.addAttribute("destinos", destinoService.buscarTodosDestinos());
			atributos.addAttribute("motoristas", motoristaService.disponivelBuscarTodosMotoristas());
			atributos.addAttribute("automoveis", automovelService.disponivelBuscarTodosAutomoveis());
			atributos.addAttribute("rotas", rotaService.buscarTodasRotas());
			
			populateDefaultModel(dropd);
			//guarda ids com get compara na view
			atributos.addAttribute("idDestinoAgendamentoGet",agendamento.getIdDestinoAgendamento());
			atributos.addAttribute("idMotoristaAgendamentoGet",agendamento.getIdMotoristaAgendamento());
			atributos.addAttribute("idAutomovelAgendamentoGet",agendamento.getIdAutomovelAgendamento());
			atributos.addAttribute("idRotaAgendamentoGet",agendamento.getIdRotaAgendamento());
			
			//System.out.println("Vendo aqui !!" + agendamento.getIdDestinoAgendamento());
			return "agendamento/cadastro-agendamento";

		} else {

			agendamentoService.inserirAgendamento(agendamento);

			attributes.addFlashAttribute("mensagemOk", "AGENDAMENTO SALVO COM SUCESSO");

			return ("redirect:/agendamento/gerencia-all-agendamento");

		}

	}

	/********************************************************************************/

	@RequestMapping(value = { "/updateAgendamento/{idAgendamento}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idAgendamento") Integer idAgendamento,
			Model atributos, Model dropd) {

		ModelAndView model = new ModelAndView("agendamento/atualiza-agendamento");

		//try {

			Agendamento agendamento = agendamentoService.buscarAgendamentoPorId(idAgendamento);

			model.addObject("agendamento", agendamento);

			atributos.addAttribute("destinos", destinoService.buscarTodosDestinos());
			atributos.addAttribute("motoristas", motoristaService.disponivelBuscarTodosMotoristas());
			atributos.addAttribute("automoveis", automovelService.disponivelBuscarTodosAutomoveis());
			atributos.addAttribute("rotas", rotaService.buscarTodasRotas());

			populateDefaultModel(dropd);

			return model;

		//} catch (Exception ex) {
		//	return new ModelAndView("errors/error-id-notfound");
		//} 

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarAgendamento", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("agendamento") @Valid Agendamento agendamento, BindingResult result,
			RedirectAttributes attributes, Model dropd, Model atributos) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			
			atributos.addAttribute("destinos", destinoService.buscarTodosDestinos());
			atributos.addAttribute("motoristas", motoristaService.disponivelBuscarTodosMotoristas());
			atributos.addAttribute("automoveis", automovelService.disponivelBuscarTodosAutomoveis());
			atributos.addAttribute("rotas", rotaService.buscarTodasRotas());
			
			populateDefaultModel(dropd);
			
			atributos.addAttribute("idDestinoAgendamentoGet",agendamento.getIdDestinoAgendamento());
			atributos.addAttribute("idMotoristaAgendamentoGet",agendamento.getIdMotoristaAgendamento());
			atributos.addAttribute("idAutomovelAgendamentoGet",agendamento.getIdAutomovelAgendamento());
			atributos.addAttribute("idRotaAgendamentoGet",agendamento.getIdRotaAgendamento());
			
			return "agendamento/atualiza-agendamento";

		} else {

			agendamentoService.atualizarAgendamento(agendamento);

			attributes.addFlashAttribute("mensagemOk", "AGENDAMENTO ATUALIZADO COM SUCESSO");
			attributes.addFlashAttribute("idViewAtualiza",agendamento.getIdAgendamento());
			return ("redirect:/agendamento/gerencia-all-agendamento");
		}

	}
	
	
	/********************************************************************************/

	
	@RequestMapping(value = { "/consultaAgendamento/{idAgendamento}" }, method = RequestMethod.GET)
	public ModelAndView consulta(@PathVariable("idAgendamento") Integer idAgendamento,
			Model atributos, Model dropd) {

		ModelAndView model = new ModelAndView("agendamento/consulta-agendamento");

		//try {

			Agendamento agendamento = agendamentoService.buscarAgendamentoPorId(idAgendamento);

			model.addObject("agendamento", agendamento);

			
			return model;

		//} catch (Exception ex) {
		//	return new ModelAndView("errors/error-id-notfound");
		//} 

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
