package org.mql.gc.actions.validators;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("org.mql.gc.actions.validators.NameValidator")
public class NameValidator implements Validator {

	private static final Pattern name_PATTERN = Pattern.compile("[a-zA-Z0-9 _-]+");

			@Override
			 public void validate(FacesContext facesContext,UIComponent uiComponent,Object o) throws ValidatorException {
	
				  if (o == null) {
				    return;
				  }
	
				  String name = (String) o;
				  boolean matches = name_PATTERN.matcher(name).matches();
				  
				  if (!matches) {
				    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "name is invalid", null);
				    throw new ValidatorException(msg);
				  }

			 }
}
