package org.mql.gc.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import org.mql.gc.actions.FileSaver;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.models.Cas;

public class CaseDaoService {
	private CaseDao casDao;
	private Cas cas;
	
	
	private FileSaver fileSaver;
	
	
	public CaseDaoService() {
		casDao=new CaseDao();
		fileSaver=new FileSaver(); 
	}

	public CaseDaoService(CaseDao casDao) {
		super();
		this.casDao = casDao;
	}
	
	public void create(Cas cas) {
		System.out.println("service");
		casDao.insererCas(cas); 
		System.out.println(cas);
	}
	public void savePhoto(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\uploadedFiles\\Images");
		File file=new File(chemin,getUniqueImageName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContentI(file.toString());
	}
	private String getUniqueImageName() {
		String imgPrefix = "img";
		String imgSufix = ".jpg";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public void saveVideo(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\uploadedFiles\\Videos");
		File file=new File(chemin,getUniqueVideoName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContentV(file.toString());
	}
	private String getUniqueVideoName() {
		String imgPrefix = "vid";
		String imgSufix = ".mp4";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public void savePdf1(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\uploadedFiles\\Pdf");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent1(file.toString());
	}
	public void savePdf2(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\uploadedFiles\\Pdf");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent2(file.toString());
	}
	public void savePdf3(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\uploadedFiles\\Pdf");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent3(file.toString());
	}
	private String getUniquePdfName() {
		String imgPrefix = "doc";
		String imgSufix = ".pdf";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
}