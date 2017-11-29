package testJava;

import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.models.Association;

public class Test {
	
	
	public Test(){
		exp01();
	}
	
	
	public static void main(String[] args) {
		new Test();
	}
	
	public void exp01(){
		Association ass=new Association();
		AssociationDao dao = new AssociationDaoImpl();
		ass.setName("hassan");
		ass.setDescription("description hassan");
		dao.add(ass);
		System.out.println("test");
	}

}
