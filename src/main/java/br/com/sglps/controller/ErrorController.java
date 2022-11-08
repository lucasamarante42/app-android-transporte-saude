package br.com.sglps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
 
    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
         
        ModelAndView errorPage = new ModelAndView("errorPage");
        String errorMsg = "";
        String codeError = "";
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
            	codeError = "Http Error Code: 400";
                errorMsg = "Ops. Requisição inválida!";
                break;
            }
            case 401: {
            	codeError = "Http Error Code: 401";
                errorMsg = "Ops. Não autorizado!";
                break;
            }
            case 404: {
            	codeError = "Http Error Code: 404";
                errorMsg = "Ops. Requisição não encontrada!";
                break;
            }
            case 500: {
            	codeError = "Http Error Code: 500";
                errorMsg = "Ops. Serviço Indisponível!";
                break;
            }
        }
        errorPage.addObject("codeError",codeError);
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("msgAdmin","Para maiores informações entre em contato com o Administrador.");
        return errorPage;
    }
     
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
    
    @RequestMapping(value = "500Error", method = RequestMethod.GET)
    public void throwRuntimeException() {
        throw new NullPointerException("Throwing a null pointer exception");
    }
}