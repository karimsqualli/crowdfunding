package testHassan;
import java.io.File;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test {

	private String message ; 
	
	public Test(){
		super();
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void printMessage(){
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		File file = new File("WebContent/WEB-INF/springIOC.xml");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(file)); 
		if(factory.containsBean("test")){
		System.err.println("yes");	
		}
		else {
			System.out.println("no");
		}
		
	}	
}
