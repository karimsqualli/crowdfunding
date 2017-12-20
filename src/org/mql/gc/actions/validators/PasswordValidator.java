package org.mql.gc.actions.validators;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("org.mql.gc.actions.validators.PasswordValidator")
public class PasswordValidator implements Validator {

	private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]{6,}");

			@Override
			 public void validate(FacesContext facesContext,UIComponent uiComponent,Object o) throws ValidatorException {
	
				  if (o == null) {
				    return;
				  }
	
				  String password = (String) o;
				  boolean matches = PASSWORD_PATTERN.matcher(password).matches();
				  
				  if (!matches) {
				    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "password is invalid", null);
				    throw new ValidatorException(msg);
				  }

			 }
}
