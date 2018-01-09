package org.mql.gc.actions;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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

public class InsertCaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Cas cas;
	private ServiceImpl service;

	
	public InsertCaseBean() {
		cas=new Cas();
	}


	@PostConstruct
	public void innit(){
		System.out.println("$$ post construct InsertCaseBean $$ ");
	}
	
	
	public String insertCase() {
		HttpSession session = SessionUtils.getSession();
		int ida =(int)session.getAttribute("idAssociation");
		System.out.println("id association = "+ida);
		cas.setDate_ajout(new Timestamp( System.currentTimeMillis() ));
		cas.setIdAssociation(ida);
		service.create(cas);
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
				service.savePhoto(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre image ", cas.getImg().getFileName() + "a �t� enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre image n'a pas �t� enregistrer, veuillez r�essayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFileV(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setVideo(event.getFile());
				InputStream inputStream = cas.getVideo().getInputstream();
				service.saveVideo(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre video ", cas.getImg().getFileName() + "a �t� enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre video n'a pas �t� enregistrer, veuillez r�essayer !");
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
				service.savePdf1(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre document ", cas.getPdf1().getFileName() + "a �t� enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre document n'a pas �t� enregistrer, veuillez r�essayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFile2(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setPdf2(event.getFile());
				InputStream inputStream = cas.getPdf2().getInputstream();
				service.savePdf2(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre document ", cas.getPdf2().getFileName() + "a �t� enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre document n'a pas �t� enregistrer, veuillez r�essayer !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	public void uploadFile3(FileUploadEvent event) {
		if (event.getFile() != null) {
			try {
				cas.setPdf3(event.getFile());
				InputStream inputStream = cas.getPdf3().getInputstream();
				service.savePdf3(inputStream, cas);
				System.out.println(cas);
				FacesMessage message = new FacesMessage("Votre document ", cas.getPdf3().getFileName() + "a �t� enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Votre document n'a pas �t� enregistrer, veuillez r�essayer !");
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

	public ServiceImpl getService() {
		return service;
	}

	public void setService(ServiceImpl service) {
		this.service = service;
	}
	
	

}
