package org.mql.gc.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.mql.gc.models.Case;
import org.mql.gc.models.City;
import org.mql.gc.services.Service;
import org.mql.gc.utils.SessionUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class InsertCaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Case caseObject;
	private Service service;						//D:/ProjetGL3/WebContent/static/
	private static final String BASE_STATIC_PATH = "C:/Users/SALAM/workspace/CrowdFunding`/crowdfunding/repoGit/WebContent/static/";
	private static final String BASE_SERVER_STATIC_PATH = "./static/";
	private static final String IMAGE_DIR = "images";
	private static final String VIDEO_DIR = "videos";
	private static final String PDF_DIR = "pdf";
	
	public String insertCase() {
		System.out.println("$$$$$$$$$$$");
		HttpSession session = SessionUtils.getSession();
		int id =(int)session.getAttribute("idAssociation");
		initialiserDateInscription();
		caseObject.setIdAssociation(id);
		service.addCase(caseObject);
		return "index?faces-redirect=true";
	}

	public Case getCaseObject() {
		return caseObject;
	}

	public void setCaseObject(Case caseObject) {
		this.caseObject = caseObject;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
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
        UploadedFile uploadedPhoto=event.getFile();
            if (uploadedPhoto!=null) {
            	try {
            		File chemin=new File(BASE_STATIC_PATH + IMAGE_DIR);
            		File file=new File(chemin,getUniqueImageName());
            		InputStream inputStream = uploadedPhoto.getInputstream();
            		save(inputStream, file);
            	caseObject.setFileContentI(BASE_SERVER_STATIC_PATH + IMAGE_DIR + "/" + getUniqueImageName());
		        FacesMessage message = new FacesMessage("Votre fichier ", uploadedPhoto.getFileName() + "a ete enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				} catch (Exception e) {
					e.printStackTrace();
					FacesMessage message = new FacesMessage("Votre fichier n'a pas ete enregistrer, veuillez reessayer !");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
                }
	}
	
	public void uploadFileV(FileUploadEvent event) {
        UploadedFile uploadedVideo=event.getFile();
            if (uploadedVideo!=null) {
            	try {
            		File chemin=new File(BASE_STATIC_PATH + VIDEO_DIR);
            		File file=new File(chemin,getUniqueVideoName());
            		InputStream inputStream = uploadedVideo.getInputstream();
            		save(inputStream, file);
            	caseObject.setFileContentV(BASE_SERVER_STATIC_PATH + VIDEO_DIR + "/" + getUniqueVideoName());
		        FacesMessage message = new FacesMessage("Votre video ", uploadedVideo.getFileName() + "a ete enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				} catch (Exception e) {
					e.printStackTrace();
					FacesMessage message = new FacesMessage("Votre video n'a pas ete enregistrer, veuillez reessayer !");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
                }
	}
	
	public void uploadFile1(FileUploadEvent event) {
        UploadedFile uploadedFile=event.getFile();
            if (uploadedFile!=null) {
            	try {
            		File chemin=new File(BASE_STATIC_PATH + PDF_DIR);
            		File file=new File(chemin,getUniquePdfName());
            		InputStream inputStream = uploadedFile.getInputstream();
            		save(inputStream, file);
            	caseObject.setFileContent1(BASE_SERVER_STATIC_PATH + PDF_DIR + "/" + getUniquePdfName());
		        FacesMessage message = new FacesMessage("Votre fichier ", uploadedFile.getFileName() + "a ete enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				} catch (Exception e) {
					e.printStackTrace();
					FacesMessage message = new FacesMessage("Votre fichier n'a pas ete enregistrer, veuillez reessayer !");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
                }
	}
	
	public void uploadFile2(FileUploadEvent event) {
        UploadedFile uploadedFile=event.getFile();
            if (uploadedFile!=null) {
            	try {
            		File chemin=new File(BASE_STATIC_PATH + PDF_DIR);
            		File file=new File(chemin,getUniquePdfName());
            		InputStream inputStream = uploadedFile.getInputstream();
            		save(inputStream, file);
            	caseObject.setFileContent2(BASE_SERVER_STATIC_PATH + PDF_DIR + "/" + getUniquePdfName());
		        FacesMessage message = new FacesMessage("Votre fichier ", uploadedFile.getFileName() + "a ete enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				} catch (Exception e) {
					e.printStackTrace();
					FacesMessage message = new FacesMessage("Votre fichier n'a pas ete enregistrer, veuillez reessayer !");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
                }
            }
	
	public void uploadFile3(FileUploadEvent event) {
        UploadedFile uploadedFile=event.getFile();
            if (uploadedFile!=null) {
            	try {
            		File chemin=new File(BASE_STATIC_PATH + PDF_DIR);
            		File file=new File(chemin,getUniquePdfName());
            		InputStream inputStream = uploadedFile.getInputstream();
            		save(inputStream, file);
            	caseObject.setFileContent3(BASE_SERVER_STATIC_PATH + PDF_DIR + "/" + getUniquePdfName());
		        FacesMessage message = new FacesMessage("Votre fichier ", uploadedFile.getFileName() + "a ete enregistrer.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				} catch (Exception e) {
					e.printStackTrace();
					FacesMessage message = new FacesMessage("Votre fichier n'a pas ete enregistrer, veuillez reessayer !");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
                }
	}
	public String getUniqueImageName() {
		String imgPrefix = "img";
		String imgSufix = ".jpg";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public String getUniqueVideoName() {
		String imgPrefix = "vid";
		String imgSufix = ".mp4";
		String milieu ="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public String getUniquePdfName() {
		String imgPrefix = "doc";
		String imgSufix = ".pdf";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public void save(InputStream inputStream, File file) throws IOException {
		// we are preparing an output stream so that we can write data to the specified file.
		OutputStream output = new FileOutputStream(file);
		// copy the input stream to the output location.
		IOUtils.copy(inputStream, output);
}
	
	private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        caseObject.setAddedDate(date);
    }

	public Case getCas() {
		return caseObject;
	}

	public void setCas(Case cas) {
		this.caseObject = cas;
	}

}
