package association.Test;

import association.model.Association;
import association.service.AssociationService;

public class Test {
	
	public Test(){
		exp01();
	}
	
	
	public static void main(String[] args){
		new Test();
	}
	public void exp01(){
		
		AssociationService service = new AssociationService();
		Association as=new Association();
		as.setDescription("1qsd23");
		as.setName("45dqsf6");
	
		service.add(as);
		
	}
}
