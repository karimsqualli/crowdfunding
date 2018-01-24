package org.mql.gc.actions.validators;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("org.mql.gc.actions.validators.EmailValidator")
public class EmailValidator implements Validator {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Za-z]{2,6}");

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

		if (o == null) {
			return;
		}

		String email = (String) o;
		boolean matches = EMAIL_PATTERN.matcher(email).matches();

		if (!matches) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Email non valide", null);
			throw new ValidatorException(msg);
		}

	}
}
