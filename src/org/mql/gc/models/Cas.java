package org.mql.gc.models;

import java.sql.Timestamp;
import org.primefaces.model.UploadedFile;

public class Cas {
	//hhhhh abdellah l bba toutes options l ffsser
	private int id;
	private int idAssociation;// Long ?? ( prk ps int )
	private String titre;
	private String slogan;
	private String categorie;
	private String autreCategorie;// Prkk ???
	private String ville;
	private int duree; //plutot Date
	private double cout;
	private String description;
	private Timestamp date_ajout;
	private String fileContent1;
	private String fileContent2;
	private String fileContent3;
	private String fileName1;
	private String fileName2;
	private String fileName3;
	private String fileContentI;
	private String fileContentV;
	private boolean pending;


	public Cas() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAssociation() {
		return idAssociation;
	}

	public void setIdAssociation(int idAssociation) {
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

	public Timestamp getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(Timestamp date_ajout) {
		this.date_ajout = date_ajout;
	}

	public String getFileContent1() {
		return fileContent1;
	}

	public void setFileContent1(String fileContent1) {
		this.fileContent1 = fileContent1;
	}

	public String getFileContent2() {
		return fileContent2;
	}

	public void setFileContent2(String fileContent2) {
		this.fileContent2 = fileContent2;
	}


	public String getFileContent3() {
		return fileContent3;
	}



	public void setFileContent3(String fileContent3) {
		this.fileContent3 = fileContent3;
	}

	public String getFileContentI() {
		return fileContentI;
	}



	public void setFileContentI(String fileContentI) {
		this.fileContentI = fileContentI;
	}


	public String getFileContentV() {
		return fileContentV;
	}



	public void setFileContentV(String fileContentV) {
		this.fileContentV = fileContentV;
	}
	

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	public String getFileName3() {
		return fileName3;
	}

	public void setFileName3(String fileName3) {
		this.fileName3 = fileName3;
	}
	
	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	/*
	 * Karim Squalli
	 * fonction utilise pour comparer les cas par id
	 */
	@Override
	public boolean equals(Object o) {
		Cas c = (Cas)o;
		return this.id == c.id;
	}

}
