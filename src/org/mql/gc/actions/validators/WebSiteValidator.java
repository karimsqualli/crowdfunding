package org.mql.gc.actions.validators;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("org.mql.gc.actions.validators.WebSiteValidator")
public class WebSiteValidator implements Validator {

	private static final Pattern WEBSITE_PATTERN = Pattern.compile("(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");

			@Override
			 public void validate(FacesContext facesContext,UIComponent uiComponent,Object o) throws ValidatorException {
	
				  if (o == null) {
				    return;
				  }
	
				  String WEBSITE = (String) o;
				  boolean matches = WEBSITE_PATTERN.matcher(WEBSITE).matches();
				  
				  if (!matches) {
				    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "WEBSITE is invalid", null);
				    throw new ValidatorException(msg);
				  }

			 }
}
