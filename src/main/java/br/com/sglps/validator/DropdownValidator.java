package br.com.sglps.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.sglps.model.Agendamento;

public class DropdownValidator implements Validator {
	
	
	public boolean supports(Class<?> paramClass) {
		return Agendamento.class.equals(paramClass);
		
	}
	
	public void validate(Object obj, Errors errors) {
		
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idDestinoAgendamento", "valid.drop");
	}

	

}


