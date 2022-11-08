package br.com.sglps.exceptions;




import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("errors/error");

		mv.addObject("errorTitle", "A página não existe!");
		mv.addObject("errorDescription", "Verifique o endereço na URL do navegador.");
		mv.addObject("contactAdm","Para maiores informações entre em contato com o Administrador.");

		mv.addObject("title", "404 Error Page");

		return mv;
	}
	
	
	@ExceptionHandler(IdNotFoundException.class)
	public ModelAndView handlerIdNotFoundException() {

		ModelAndView mv = new ModelAndView("errors/error");

		mv.addObject("errorTitle", "ID não disponível!");
		mv.addObject("errorDescription", "Verifique o número do ID na URL.");
		mv.addObject("contactAdm","Para maiores informações entre em contato com o Administrador.");

		mv.addObject("title", "ID Indisponível");

		return mv;
	}
	

	
	
	
	
	

}
