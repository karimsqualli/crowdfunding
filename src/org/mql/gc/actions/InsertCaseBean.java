package org.mql.gc.actions;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;
import org.mql.gc.models.City;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

//@ManagedBean
public class InsertCaseBean implements Serializable{
	private Cas cas;
	private Service casDaoService;

	public InsertCaseBean() {
		cas = new Cas();
		casDaoService = new ServiceImpl();
	}

	public String insertCase() {
		HttpSession session = SessionUtils.getSession();
		Long ida =(Long)session.getAttribute("idAssociation");
		System.out.println("azzeazeaeazeaezaezaeazea"+ida);
		cas.setDate_ajout(new Timestamp( System.currentTimeMillis() ));
		cas.setIdAssociation(ida);
		casDaoService.create(cas);
		return "index?faces-redirect=true";
	}

	public List<String> completeVille(String lettres) {
        List<String> results = new ArrayList<String>();
        for(City ville : City.values()) {
        	if (ville.name().toLowerCase().startsWith(lettres)) {
				System.out.println(ville);
        	results.add(ville.name());
			}
        		
        }
        return results;
    }
	public String onFlowProcess(FlowEvent event) {
            return event.getNewStep();
    }
	public void uploadFileI(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setImg(event.getFile());
				InputStream inputStream = cas.getImg().getInputstream();
				casDaoService.savePhoto(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre image ", cas.getImg().getFileName() + "a été enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre image n'a pas été enregistrer, veuillez réessayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFileV(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setVideo(event.getFile());
				InputStream inputStream = cas.getVideo().getInputstream();
				casDaoService.saveVideo(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre video ", cas.getImg().getFileName() + "a été enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre video n'a pas été enregistrer, veuillez réessayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFile1(FileUploadEvent event) {
		if (event.getFile()  != null) {
			try {
				System.out.println("pdf1******************");
				cas.setPdf1(event.getFile());
				InputStream inputStream = cas.getPdf1().getInputstream();
				casDaoService.savePdf1(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre document ", cas.getPdf1().getFileName() + "a été enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre document n'a pas été enregistrer, veuillez réessayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFile2(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setPdf2(event.getFile());
				InputStream inputStream = cas.getPdf2().getInputstream();
				casDaoService.savePdf2(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre document ", cas.getPdf2().getFileName() + "a été enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre document n'a pas été enregistrer, veuillez réessayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFile3(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setPdf3(event.getFile());
				InputStream inputStream = cas.getPdf3().getInputstream();
				casDaoService.savePdf3(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre document ", cas.getPdf3().getFileName() + "a été enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre document n'a pas été enregistrer, veuillez réessayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}

	public Cas getCas() {
		return cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

}
