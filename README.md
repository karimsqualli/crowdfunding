# CrowdFunding Humanitaire

### Prerequisites

les logiciels suivant sont requis pour pouvoir lancer l'application

* Java 8
* Apache Tomecat 9.0
* Mysql
* Git (Pour collaboration et clone)

### Installing

On va premierement cloner le code source

```
git clone https://github.com/karimsqualli/crowdfunding.git
```


### Convention Nommage

**Data Access Object**
```
public interface AssociationDao {
	
	// On suit la convention de nommage CRUD
	// Created-Read-Update-Delete pour les methode 
	// de base
	
	public void create(Association a) ;
	public Association read(Long id) ;
	public Association update(Association e) ;
	public void delete(Long id) ;
	
	public List<Association> findAll() ;
	public Association findById(Long id) ;
	public Association findByName(String name);
	public boolean loginAssociation(String email,String password);
	Association findByEmail(String email);
}


```
