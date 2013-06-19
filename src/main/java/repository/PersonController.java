package repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Data;
import entity.Person;
import entity.Role;
 
@Controller
public class PersonController {
 
    @Autowired
    private PersonDao personDao;
 
    @RequestMapping(value="/person")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null){
        	Data data1 = new Data("zip");
        	Role role1 = new Role("admin");
        	Person person = new Person(name,21);
        	data1.setPerson(person);
            	
        	List<Data> datas =  new ArrayList<Data>();
        	datas.add(data1);
        	
        	List<Role> roles =  new ArrayList<Role>();
        	roles.add(role1);
        	
        	person.setData(datas);
        	person.setRoles(roles);
        	
        	
        	
        	personDao.persist(person);
        	
        }
        // Prepare the result view (person.jsp):
        return new ModelAndView("person.jsp", "personDao", personDao);
    }
}