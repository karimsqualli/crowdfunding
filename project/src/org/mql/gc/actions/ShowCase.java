package org.mql.gc.actions;

import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.mql.gc.models.Cas;

@ManagedBean
@ApplicationScoped
public class ShowCase {
	private Cas cas;
	private 
//	private List<Cas> list;
	
	public ShowCase() {
		cas = new Cas();
		list = new Vector<>();
	}
	
	@PostConstruct
	public void list() {
//		list.add(new Cas(11, "AA", 100, 130));
//		list.add(new Cas(25, "BB", 200, 50));
//		list.add(new Cas(36, "CC", 150, 10));
	}

	public Cas getCas() {
		return cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public List<Cas> getList() {
		return list;
	}

	public void setList(List<Cas> list) {
		this.list = list;
	}
	
	
}
