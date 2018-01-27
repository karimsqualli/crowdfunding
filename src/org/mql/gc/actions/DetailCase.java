package org.mql.gc.actions;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.mql.gc.models.Cas;

public class DetailCase {
	private Cas cas;
	private StreamedContent pdf1;
	private String nameAsso;
	

		public DetailCase() {}
	
//	    public void FileDownloadView() {   
//	        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:\Users\SALAM\workspace\CrowdFunding\repoGit\WebContent\static\pdf\doc171219135041.pdf");
//	        pdf1 = new DefaultStreamedContent(stream, "application/pdf", "downloaded_optimus.pdf");
//	    }
	    
	    
		  @PostConstruct     
		    public void init() {
			  try {
			        //----------------------------------
			            Document doc = new Document();

			            OutputStream out = new ByteArrayOutputStream();
			            PdfWriter writer = PdfWriter.getInstance(doc, out);

			            doc.open();
			            doc.add(new Paragraph("Hello World. ok........"));
			            doc.close(); 
			            out.close();

			            InputStream in =new ByteArrayInputStream(((ByteArrayOutputStream)out).toByteArray());

			            pdf1 = new DefaultStreamedContent(in, "application/pdf");
			        //-------
			        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			        byte[] b = (byte[]) session.get("reportBytes");
			        if (b != null) {
			            pdf1 = new DefaultStreamedContent(new ByteArrayInputStream(b), "application/pdf");
			        }            
			        } catch (Exception e) {
			        }

		    }
		    //==================================================================
		    public StreamedContent getPdf1() {
		        if (FacesContext.getCurrentInstance().getRenderResponse()) {
		            return new DefaultStreamedContent();
		        } else {
		            return pdf1;
		        }
		     }
		    //==================================================================
		    public void setPdf1(StreamedContent streamedContent) {
		        this.pdf1 = streamedContent;
		    }
		    //=====================================================================

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


