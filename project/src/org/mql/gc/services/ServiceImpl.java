package org.mql.gc.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.mql.gc.actions.FileSaver;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;

public class ServiceImpl implements Service {
	private CaseDao casDao;
	private Cas cas;
	private FileSaver fileSaver;
	private AssociationDao dao;
	
	
	public ServiceImpl() {
	dao	= new AssociationDaoImpl();
	casDao=new CaseDao();
	fileSaver=new FileSaver(); 
	}
	
//******************************Association************************	

	public void add(Association e) {
		System.out.println("service");
						
		if(nameExist(e.getName()))
			System.out.println("association existe deja ");
		else {
			dao.add(e);
			System.out.println("association ajoutée : "+e.getName());
		}
	}
	
	public Association edite(Association e) {
		return dao.edite(e);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public List<Association> findAll() {
		return dao.findAll();
	}
	
	public Association findById(Long id) {
		return dao.findById(id);
	}

	public boolean nameExist(String name) {
		if(dao.findByName(name)!= null) 
			return true ; 	
		return false;
	}

	public boolean connectAssociation(String email, String password) {
	
		return dao.loginAssociation(email, password);
	}

//*********************************Cas*****************************************
	
	public void create(Cas cas) {
		System.out.println("service");
		casDao.insererCas(cas); 
		System.out.println(cas);
	}
	public void savePhoto(InputStream inputStream, Cas cas) throws IOException {
		//File chemin = new File(CaseDao.class.getResource("/resources/img").getFile());
		//System.out.println(chemin.getAbsolutePath());
		ServletContext s = (ServletContext)FacesContext.getCurrentInstance().getExternalContext();
		String ss = s.getContextPath();
		System.out.println(ss);
		File file=new File(ss,getUniqueImageName());
		fileSaver.save(inputStream, file);
		cas.setFileContentI(file.toString());
	}
	public String getUniqueImageName() {
		String imgPrefix = "img";
		String imgSufix = ".jpg";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public void saveVideo(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("resources/video/");
		File file=new File(chemin,getUniqueVideoName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContentV(file.toString());
	}
	public String getUniqueVideoName() {
		String imgPrefix = "vid";
		String imgSufix = ".mp4";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	public void savePdf1(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("resources/doc/");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent1(file.toString());
	}
	public void savePdf2(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\project\\uploadedFiles\\Pdf");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent2(file.toString());
	}
	public void savePdf3(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("resources/doc/");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent3(file.toString());
	}
	public String getUniquePdfName() {
		String imgPrefix = "doc";
		String imgSufix = ".pdf";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	
//*****************************************************************************	
	
	
}
