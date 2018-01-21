package org.mql.gc.actions;

import java.io.InputStream;
import javax.faces.context.FacesContext;
import org.mql.gc.models.Cas;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class DetailCase {
	private Cas cas;
	private StreamedContent pdf1;
	private String nameAsso;
	
		public DetailCase() {}
	
	    public void FileDownloadView() {   
	        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:/Users/SALAM/workspace/CrowdFunding/crowdfunding/project/uploadedFiles/Images/img171215210704.jpg");
	        pdf1 = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
	    }
	 
		public StreamedContent getPdf1() {
			return pdf1;
		}
		public Cas getCas() {
			return cas;
		}

		public void setCas(Cas cas) {
			this.cas = cas;
		}
		
		public String getNameAsso() {
			return nameAsso;
		}
		
		public void setNameAsso(String nameAsso) {
			this.nameAsso = nameAsso;
		}
}


