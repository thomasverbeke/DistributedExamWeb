package repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import entity.Data;
import entity.Person;
import entity.Role;
 
@Controller
public class PersonController {
 
    @Autowired
    private PersonDao personDao;
 
    @Autowired
    PersonValidator validator;

    
    @RequestMapping(value="/person")
    public ModelAndView AddPerson(@ModelAttribute("validationForm") Person person, BindingResult result,SessionStatus status) {
       
    	validator.validate(person, result);
    	
        if (result.hasErrors()){
        	//return new ModelAndView();
        } else {
        	//persist 
        	
        	Data data1 = new Data("zip");
        	Role role1 = new Role("admin");
   
        	data1.setPerson(person);
            	
        	List<Data> datas =  new ArrayList<Data>();
        	datas.add(data1);
        	
        	List<Role> roles =  new ArrayList<Role>();
        	roles.add(role1);
        	
        	person.setData(datas);
        	person.setRoles(roles);
        	
        	personDao.persist(person);
        	
        }
        
        return new ModelAndView("person", "personDao", personDao);
    }
}