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
					errors.rejectValue("name","validation.name", new Object[] {new Integer(MIN_NAME)},"You're too young for this service");
				}
			} else {
				errors.rejectValue("name","validation.name", new Object[] {new Integer(MIN_NAME)},"You're too young for this service");
			}
			
			if (person.getAge() != null){
				if (person.getAge() < MIN_AGE){
					errors.rejectValue("age","validation.age", new Object[] {new Integer(MIN_AGE)},"You're too young for this service");
				}
			} else {
				errors.rejectValue("age","validation.age", new Object[] {new Integer(MIN_AGE)},"You're too young for this service");
			}
			
		}
	}

}
