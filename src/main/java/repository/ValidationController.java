package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import entity.Data;
import entity.Person;
import entity.Role;

@Controller  
@RequestMapping(value="/validationform.htm") 
public class ValidationController {  
  
	@Autowired
    private PersonDao personDao;
 
    @Autowired
    PersonValidator validator;
    
	// Display the form on the get request  
	@RequestMapping(method = RequestMethod.GET)  
	public String showForm(Map model) {  
		 Person person = new Person();  
		 model.put("validationForm", person);  
		 return "validationForm";  
	}  
  
	// Process the form.  
	@RequestMapping(method = RequestMethod.POST)  
	public String processValidatinForm(@ModelAttribute("validationForm") Person person, BindingResult result,SessionStatus status) {  
			
		validator.validate(person, result);
    	
        if (result.hasErrors()){
			return "validationForm";
		} else {
        	status.setComplete();
        	//persist 
        	
        	Data data1 = new Data("zip");
        	Role role1 = new Role("admin");
   
        	data1.setPerson(person);
            	
        	List<Data> datas =  new ArrayList<Data>();
        	datas.add(data1);
        	
        	List<Role> roles =  new ArrayList<Role>();
        	roles.add(role1);
        	
        	person.setDatas(datas);
        	person.setRoles(roles);
        	
        	personDao.persist(person);
        	
		}
        
        return "redirect:person.htm";
	}  
  
}  