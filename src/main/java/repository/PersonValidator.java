package repository;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import entity.Person;

@Service
public class PersonValidator implements Validator {

	private static final Integer MIN_AGE = 14;
	private static final int MIN_NAME = 4;
 
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		if (person !=null){
			if (person.getName() != null){
				if (person.getName().length() < MIN_NAME){
					errors.rejectValue("name","string","your name has to be a least 4 char's");
				}
			} else {
				errors.rejectValue("name","string","enter a name");
			}
			
			if (person.getAge() != null){
				if (person.getAge() < MIN_AGE){
					errors.rejectValue("age","bing","error.too-high");
				}
			} else {
				errors.rejectValue("age","bing","error.too-high");
			}
			
		}
	}

}
