package br.com.sglps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sglps.model.Paciente;
import br.com.sglps.service.InterfacePacienteService;

@Controller
@RequestMapping(value = "/paciente/")
public class PacienteController {

	@Autowired
	InterfacePacienteService pacienteService;

	/********************************************************************************/

	@RequestMapping(value = { "/gerencia-all-paciente" }, method = RequestMethod.GET)
	public ModelAndView homePrincipal() {

		ModelAndView model = new ModelAndView("paciente/gerencia-all-paciente");

		List<Paciente> listaPaciente = pacienteService.buscarTodosPacientes();
		model.addObject("listPaciente", listaPaciente);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = { "/cadastro-paciente" }, method = RequestMethod.GET)
	public ModelAndView add(Model atributos) {

		ModelAndView model = new ModelAndView("paciente/cadastro-paciente");

		Paciente paciente = new Paciente();

		model.addObject("paciente", paciente);
		
		populateDefaultModel(atributos);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/salvarPaciente", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("paciente") @Valid Paciente paciente, BindingResult result,
			RedirectAttributes attributes, Model dropd) {

		if (result.hasErrors()) {
			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			
			populateDefaultModel(dropd);
			return "paciente/cadastro-paciente";

		} else {

			pacienteService.inserirPaciente(paciente);

			attributes.addFlashAttribute("mensagemOk", "PACIENTE SALVO COM SUCESSO");

			return ("redirect:/paciente/gerencia-all-paciente");

		}

	}

	/********************************************************************************/

	@RequestMapping(value = { "/updatePaciente/{idPaciente}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idPaciente") Integer idPaciente, Model dropd) {

		ModelAndView model = new ModelAndView("paciente/atualiza-paciente");

		Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);

		model.addObject("paciente", paciente);

		populateDefaultModel(dropd);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarPaciente", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("paciente") @Valid Paciente paciente, BindingResult result,
			RedirectAttributes attributes, Model dropd) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			populateDefaultModel(dropd);
			return "paciente/atualiza-paciente";

		} else {

			pacienteService.atualizarPaciente(paciente);

			attributes.addFlashAttribute("mensagemOk", "PACIENTE ATUALIZADO COM SUCESSO");
			attributes.addFlashAttribute("idViewAtualiza",paciente.getIdPaciente());
			return ("redirect:/paciente/gerencia-all-paciente");
		}

	}

	/********************************************************************************/

	private void populateDefaultModel(Model modelDropDown) {

		Map<String, String> necessidadeEspecialPaciente = new LinkedHashMap<String, String>();
		necessidadeEspecialPaciente.put("", "Selecione a necessidade especial");
		necessidadeEspecialPaciente.put("Não", "Não");
		necessidadeEspecialPaciente.put("Sim", "Sim");		

		modelDropDown.addAttribute("necessidadeEspecialPacienteList", necessidadeEspecialPaciente);

		Map<String, String> necessidadeAcompanhantePaciente = new LinkedHashMap<String, String>();
		necessidadeAcompanhantePaciente.put("", "Selecione a necessidade acompanhante");
		necessidadeAcompanhantePaciente.put("Não", "Não");
		necessidadeAcompanhantePaciente.put("Sim", "Sim");
		
		modelDropDown.addAttribute("necessidadeAcompanhantePacienteList", necessidadeAcompanhantePaciente);

		Map<String, String> hemodialisePaciente = new LinkedHashMap<String, String>();
		hemodialisePaciente.put("", "Selecione a hemodiálise");
		hemodialisePaciente.put("Não", "Não");
		hemodialisePaciente.put("Sim", "Sim");
		

		modelDropDown.addAttribute("hemodialisePacienteList", hemodialisePaciente);

	}

}
