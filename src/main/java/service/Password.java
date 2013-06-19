package service;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement	
public class Password {
	private String pass;
	
	
	public void setPassword(String pass){
		this.pass = pass;
	}
	
	public String getPassword(){
		return pass;
	}
}
