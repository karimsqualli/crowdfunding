package org.mql.gc.actions;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CounterBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int count=5 ; 
	
	public int getCount() {  
		return count;  
	}  
	public void setCount(int count) {  
		this.count = count;  
	}  
	public void increment() {  
		count--;  
	}  
}
