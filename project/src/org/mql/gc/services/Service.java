package org.mql.gc.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;

public interface Service {
    //**********************************Association**********************************
	public void add(Association e) ;
	public Association edite(Association e) ;
	public void delete(Long id) ;
	public List<Association> findAll() ;
	public Association findById(Long id) ;
	public boolean nameExist(String name);
	public boolean connectAssociation(String email,String password);
	//************************************Case**************************************
	public void create(Cas cas);
	public void savePhoto(InputStream inputStream, Cas cas) throws IOException;
	public String getUniqueImageName() ;
	public void saveVideo(InputStream inputStream, Cas cas) throws IOException ;
	public String getUniqueVideoName() ;
	public void savePdf1(InputStream inputStream, Cas cas) throws IOException ;
	public void savePdf2(InputStream inputStream, Cas cas) throws IOException ;
	public void savePdf3(InputStream inputStream, Cas cas) throws IOException ;
	public String getUniquePdfName();
}
