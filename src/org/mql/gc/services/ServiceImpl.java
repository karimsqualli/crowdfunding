package org.mql.gc.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.mql.gc.actions.FileSaver;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.dao.CaseDaoImpl;
import org.mql.gc.dao.DonateurDaoImpl;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public class ServiceImpl implements Service {
	
	
	private static final String BASE_STATIC_PATH = "/home/karim/Project/crowdfunding/WebContent/static/";
	private static final String BASE_SERVER_STATIC_PATH = "./static/";
	
	
	private static final String IMAGE_DIR = "images";
	private static final String VIDEO_DIR = "videos";
	private static final String PDF_DIR = "pdf";

	
	private CaseDao casDao;
	private FileSaver fileSaver;
	private AssociationDao dao;
	private DonateurDaoImpl DonatorDao;

	
	
	
	
	public ServiceImpl() {
	DonatorDao=new DonateurDaoImpl();
	dao	= new AssociationDaoImpl();
	casDao=new CaseDaoImpl();
	fileSaver=new FileSaver(); 
	}
	
//******************************Association************************	

	public void add(Association e) {
						
		if(nameExist(e.getName()))
			System.out.println("association existe deja ");
		else {
			dao.create(e);
			System.out.println("association ajout�e : "+e.getName());
		}
	}
	
	public Association edite(Association e) {
		return dao.update(e);
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
	public Association findByEmail(String email) {
		return dao.findByEmail(email);
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
	//FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/exportFiles/file.pdf");
	public void savePhoto(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File(BASE_STATIC_PATH + IMAGE_DIR);
		File file=new File(chemin,getUniqueImageName());
		fileSaver.save(inputStream, file);
		cas.setFileContentI(BASE_SERVER_STATIC_PATH + IMAGE_DIR + "/" + getUniqueImageName());
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
		File chemin=new File(BASE_STATIC_PATH + VIDEO_DIR);
		File file=new File(chemin,getUniqueVideoName());
		fileSaver.save(inputStream, file);
		cas.setFileContentV(BASE_SERVER_STATIC_PATH + IMAGE_DIR + "/" + getUniqueVideoName());
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
		File chemin=new File(BASE_STATIC_PATH + PDF_DIR);
		File file=new File(chemin,getUniquePdfName());
		fileSaver.save(inputStream, file);
		cas.setFileContent1(BASE_SERVER_STATIC_PATH + PDF_DIR + "/" + getUniquePdfName());
	}
	public void savePdf2(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\project\\uploadedFiles\\Pdf");
		File file=new File(chemin,getUniquePdfName());
		System.out.println(file);
		fileSaver.save(inputStream, file);
		cas.setFileContent2("uploadedFiles/Pdf/" + getUniquePdfName());
	}
	public void savePdf3(InputStream inputStream, Cas cas) throws IOException {
		File chemin=new File("C:\\Users\\SALAM\\workspace\\CrowdFunding\\crowdfunding\\toTheLast4\\WebContent\\uploadedFiles\\Pdf");
		File file=new File(chemin,getUniquePdfName());
		fileSaver.save(inputStream, file);
		cas.setFileContent3("uploadedFiles/Pdf/" + getUniquePdfName());
	}
	public String getUniquePdfName() {
		String imgPrefix = "doc";
		String imgSufix = ".pdf";
		String milieu ="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		milieu=sdf.format(new Date());
		return imgPrefix+milieu+imgSufix;
	}
	
	public List<Cas> afficherListcas() {
		return casDao.afficherListcas();
	}
	
	
	public List<Cas> afficherListcas(String nom, String category) {
		return casDao.afficherListcas(nom ,category);
	}
	
	
	
	//********************************Donnateur*********************************************	
		public boolean addDonator(Donnateur e) {
			System.out.println("service");
			if(emailDonatorExist(e.getEmail())){
				return false;
			}
			else {
				DonatorDao.create(e);
				return true ; 
			}	
		}
		
		public Donnateur editeDonator(Donnateur e) {
			return DonatorDao.update(e);
		}

		
		public void deleteDonator(Long id) {
			DonatorDao.delete(id);
		}

		
		public List<Donnateur> findAllDonator() {
			return DonatorDao.findAll();
		}
		
		public Donnateur findDonatorById(Long id) {
			return DonatorDao.findById(id);
		}

		public boolean nameDonatorExist(String name) {
			if(DonatorDao.findByName(name)!= null) 
				return true ; 
			return false;
		}
		
		public boolean emailDonatorExist(String email) {
			if(DonatorDao.findByEmail(email)!= null) 
				return true ; 
			return false;
		}
		
		public boolean passwordDonatorExist(String password) {
			if(DonatorDao.findByPassword(password)!= null) 
				return true ; 
			return false;
		}
		
		public Donnateur connectDonator(String email, String password) {
			return DonatorDao.loginDonator(email, password);
			
		}
		
		public void saveDonn(Donation donn) {
			DonatorDao.saveDonn(donn);
		}
		
		public double calc(int id) {
			return casDao.calc(id);
		}
}
