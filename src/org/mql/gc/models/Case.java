package org.mql.gc.models;

import java.sql.Timestamp;
import java.util.Date;

public class Case {
	private int id;
	private int idAssociation;
	private String title;
	private String slogan;
	private String category;
	private String city;
	private Date endDate;
	private double cost;
	private String description;
	private Timestamp addedDate;
	private String fileContent1;
	private String fileContent2;
	private String fileContent3;
	private String fileContentI;
	private String fileContentV;
	private String fileName1;
	private String fileName2;
	private String fileName3;
	private boolean pending;

	
	public Case() {
	
	}

	public Case(int id, String title) {
		super();
		this.id = id;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Timestamp addedDate) {
		this.addedDate = addedDate;
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

	
}
