package org.mql.gc.models;

import java.sql.Timestamp;
import java.util.Date;
import org.primefaces.model.UploadedFile;

public class Cas {

	private int id;
	private Long idAssociation;
	private String titre;
	private String slogan;
	private String categorie;
	private String autreCategorie;
	private String ville;
	private int duree;
	private double cout;
	private String description;
	private String numCompteBank;
	private Timestamp date_ajout;
	private UploadedFile pdf1;
	private String fileContent1;
	private UploadedFile pdf2;
	private String fileContent2;
	private UploadedFile pdf3;
	private String fileContent3;
	private UploadedFile img;
	private String fileContentI;
	private UploadedFile video;
	private String fileContentV;

	public Cas() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Long getIdAssociation() {
		return idAssociation;
	}



	public void setIdAssociation(Long idAssociation) {
		this.idAssociation = idAssociation;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getSlogan() {
		return slogan;
	}



	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}



	public String getAutreCategorie() {
		return autreCategorie;
	}



	public void setAutreCategorie(String autreCategorie) {
		this.autreCategorie = autreCategorie;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public int getDuree() {
		return duree;
	}



	public void setDuree(int duree) {
		this.duree = duree;
	}



	public double getCout() {
		return cout;
	}



	public void setCout(double cout) {
		this.cout = cout;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getNumCompteBank() {
		return numCompteBank;
	}



	public void setNumCompteBank(String numCompteBank) {
		this.numCompteBank = numCompteBank;
	}



	



	public Timestamp getDate_ajout() {
		return date_ajout;
	}



	public void setDate_ajout(Timestamp date_ajout) {
		this.date_ajout = date_ajout;
	}



	public UploadedFile getPdf1() {
		return pdf1;
	}



	public void setPdf1(UploadedFile pdf1) {
		this.pdf1 = pdf1;
	}



	public String getFileContent1() {
		return fileContent1;
	}



	public void setFileContent1(String fileContent1) {
		this.fileContent1 = fileContent1;
	}



	public UploadedFile getPdf2() {
		return pdf2;
	}



	public void setPdf2(UploadedFile pdf2) {
		this.pdf2 = pdf2;
	}



	public String getFileContent2() {
		return fileContent2;
	}



	public void setFileContent2(String fileContent2) {
		this.fileContent2 = fileContent2;
	}



	public UploadedFile getPdf3() {
		return pdf3;
	}



	public void setPdf3(UploadedFile pdf3) {
		this.pdf3 = pdf3;
	}



	public String getFileContent3() {
		return fileContent3;
	}



	public void setFileContent3(String fileContent3) {
		this.fileContent3 = fileContent3;
	}



	public UploadedFile getImg() {
		return img;
	}



	public void setImg(UploadedFile img) {
		this.img = img;
	}



	public String getFileContentI() {
		return fileContentI;
	}



	public void setFileContentI(String fileContentI) {
		this.fileContentI = fileContentI;
	}



	public UploadedFile getVideo() {
		return video;
	}



	public void setVideo(UploadedFile video) {
		this.video = video;
	}



	public String getFileContentV() {
		return fileContentV;
	}



	public void setFileContentV(String fileContentV) {
		this.fileContentV = fileContentV;
	}



	public String toString() {
		return "Cas [idAssociation=" + idAssociation + ", titre=" + titre + ", categorie=" + categorie
				+ ", autreCategorie=" + autreCategorie + ", ville=" + ville + ", duree=" + duree + ", cout=" + cout
				+ ", description=" + description + ", numCompteBank=" + numCompteBank + ", pdf1=" + pdf1
				+ ", fileContent1=" + fileContent1 + ", pdf2=" + pdf2 + ", fileContent2=" + fileContent2 + ", pdf3="
				+ pdf3 + ", fileContent3=" + fileContent3 + ", img=" + img + ", fileContentI=" + fileContentI
				+ ", video=" + video + ", fileContentV=" + fileContentV + "]";
	}

}
