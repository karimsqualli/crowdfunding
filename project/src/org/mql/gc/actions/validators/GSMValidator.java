package org.mql.gc.actions.validators;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



@FacesValidator("org.mql.gc.actions.validators.GSMValidator")
public class GSMValidator implements Validator {

	private static final Pattern GSM_PATTERN = Pattern.compile("(0|\\+212)[6][0-9]{8}");

			@Override
			 public void validate(FacesContext facesContext,UIComponent uiComponent,Object o) throws ValidatorException {
	
				  if (o == null) {
				    return;
				  }
	
				  String GSM = (String) o;
				  boolean matches = GSM_PATTERN.matcher(GSM).matches();
				  
				  if (!matches) {
				    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "GSM is invalid", null);
				    throw new ValidatorException(msg);
				  }

			 }
}
