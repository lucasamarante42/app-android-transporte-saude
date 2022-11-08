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

import br.com.sglps.model.Usuario;
import br.com.sglps.service.InterfaceUsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	InterfaceUsuarioService usuarioService;

	/********************************************************************************/

	@RequestMapping(value = { "/gerencia-all-usuario" }, method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView model = new ModelAndView("usuario/gerencia-all-usuario");

		//try{
			List<Usuario> listaUsuario = usuarioService.buscarTodosUsuarios();
			model.addObject("listUsuario", listaUsuario);

			
			
		//}catch (Exception e) {
		//	return new ModelAndView("redirect:/errors/error500");
		//}
		
		return model;
	}

	/********************************************************************************/

	@RequestMapping(value = { "/cadastro-usuario" }, method = RequestMethod.GET)
	public ModelAndView add() {

		ModelAndView model = new ModelAndView("usuario/cadastro-usuario");

		Usuario usuario = new Usuario();

		model.addObject("usuario", usuario);

		return model;

	}

	/********************************************************************************/

	@RequestMapping(value = { "/updateUsuario/{idUsuario}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idUsuario") Integer idUsuario) {

		ModelAndView model = new ModelAndView("usuario/atualiza-usuario");

		//try {
			Usuario usuario = usuarioService.buscarUsuarioPorID(idUsuario);

			// global ainda nao funciona abaixo
			// if(usuario == null) throw new IdNotFoundException();

			model.addObject("usuario", usuario);

			return model;

		//} catch (Exception ex) {
		//	return new ModelAndView("redirect:/errors/error500");

		//}

	}
	

	/********************************************************************************/

	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {

			// form validation error
			attributes.addFlashAttribute("mensagemErro", "ERRO NO CADASTRO!");
			return "usuario/cadastro-usuario";

		} else {

			//try {

				usuarioService.inserirUsuario(usuario);

				attributes.addFlashAttribute("mensagemOk", "USUÁRIO CADASTRADO COM SUCESSO");
				return ("redirect:/usuario/gerencia-all-usuario");
				
		//} catch (Exception ex) {
			//	return "errors/error500";
			//}

		}

	}

	/********************************************************************************/

	@RequestMapping(value = "/atualizarUsuario", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagemErro", "ERRO NA ATUALIZAÇÃO!");
			return "usuario/atualiza-usuario";

		} else {

			//try {
				usuarioService.atualizarUsuario(usuario);
				attributes.addFlashAttribute("mensagemOk", "USUÁRIO ATUALIZADO COM SUCESSO");
				attributes.addFlashAttribute("idViewAtualiza",usuario.getIdUsuario());
				return ("redirect:/usuario/gerencia-all-usuario");

			//} catch (Exception ex) {
			//	return "errors/error500";
			//}
		}

	}

	/********************************************************************************/

	/*
	 * @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	 * public ModelAndView delete(@PathVariable("id") int id) {
	 * 
	 * usuarioService.excluirUsuario(id);
	 * 
	 * return new ModelAndView("redirect:/usuarios/list");
	 * 
	 * }
	 */

}
