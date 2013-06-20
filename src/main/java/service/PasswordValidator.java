package service;

import javax.jws.WebService;

@WebService
public class PasswordValidator {
	public boolean validate(String pas){
		if (pas.length() > 10) return true;
		else return false;
		
	}
}



//logger -> aspectj

//page flow
//.properties
