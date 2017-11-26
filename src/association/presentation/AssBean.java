package association.presentation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import association.model.Association;
import association.service.AssociationService;




@ManagedBean(name="AssBean")
@RequestScoped
public class AssBean {

	
	private String name;
	private String description;
	private String message;
	
	
	@PostConstruct
	public void init(){
		System.out.println("postConstruct");
		name="Hassanix";
		description="descriptionX";
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void saveAss(){
		Association as=new Association();
		AssociationService service=new AssociationService();
		as.setDescription(description);
		as.setName(name);
		System.out.println("nom de l'association = "+as.getName());
		System.out.println("description = "+as.getDescription());	
		service.add(as);
		message="ajout réussie";
	}
	
	
	public void showListe(){
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
