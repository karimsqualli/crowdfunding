package org.mql.gc.actions.validators;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("org.mql.gc.actions.validators.PattenteValidator")
public class PattenteValidator implements Validator {

	private static final Pattern PATTENTE_PATTERN = Pattern.compile("[0-9]+");

			@Override
			 public void validate(FacesContext facesContext,UIComponent uiComponent,Object o) throws ValidatorException {
	
				  if (o == null) {
				    return;
				  }
				  String pattente = (String) o;
				  boolean matches = PATTENTE_PATTERN.matcher(pattente).matches();
				  
				  if (!matches) {
				    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "pattente is invalid", null);
				    throw new ValidatorException(msg);
				  }

			 }
}
