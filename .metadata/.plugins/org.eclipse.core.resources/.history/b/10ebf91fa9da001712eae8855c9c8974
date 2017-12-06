package org.mql.gc.actions;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.UploadedFile;

@FacesValidator(value="org.mql.gc.actions.ValidateFileBean")
public class ValidateFileBean implements Validator{
private FacesMessage message=null;

	
	public ValidateFileBean() {
		// TODO Auto-generated constructor stub
	}
	 @Override
	 public void validate(FacesContext context, UIComponent component, Object value)     throws ValidatorException {
	        UploadedFile file = (UploadedFile) value;
	        System.out.println(file.getContentType());
	        try {
	 
	            if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() )
	                message=new FacesMessage("Select a valid file");
	            
	            else if (!file.getContentType().endsWith("/png") && !file.getContentType().endsWith("/jpg") && !file.getContentType().endsWith("/jpeg"))
	            	message=new FacesMessage("Choisis une image : Jpg, JPEG ou PNG");
	            else if (file.getSize()>400000)
	                 message=new FacesMessage("Fichier très grand.(Taille max: 4 MB)");
	 
	            if (message!=null && !message.getDetail().isEmpty())
	                {
	                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
	                    throw new ValidatorException(message );
	                }
	 
	        } catch (Exception ex) {
	               throw new ValidatorException(new FacesMessage(ex.getMessage()));
	        }
	 
	    }
	
	public FacesMessage getMessage() {
		return message;
	}
	public void setMessage(FacesMessage message) {
		this.message = message;
	}

	 
}
