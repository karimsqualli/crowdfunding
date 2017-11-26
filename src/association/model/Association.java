package association.model;

public class Association {
	
	private String name="hassan"; 
	private String description;
	private Long id_association;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Association() {	
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Association(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getId_association() {
		return id_association;
	}

	public void setId_association(Long id_association) {
		this.id_association = id_association;
	}

	public Association(String name) {
		super();
		this.name = name;
	}
	
}
