package api;

import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Person;

import repository.PersonDao;

@Controller
@RequestMapping("api")
public class PersonService {
	
	@Autowired
	PersonDao repo;
	
	// Non specific method
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Person randomPerson(@PathVariable String name) throws ResourceNotFoundException {
		
		Person person = (Person) repo.getPersonByName(name);
		
		if (person==null){
			throw new ResourceNotFoundException("Id not found in the request");
		} else {
			return person;
		}
		
	}

	// Specific for json
	@RequestMapping(value = "/person/{id}.json", method = RequestMethod.GET)
	@ResponseBody
	public Person getByIdJSON(@PathVariable("id") int id) {
		Person person = (Person) repo.getPersonByID(id);
		if (person==null) throw new ResourceNotFoundException("Id not found in the request");
		return person;
	}
	
	// Specific for xml
	@RequestMapping(value = "/person/{id}.xml", method = RequestMethod.GET)
	@ResponseBody
	public Person getByIdXML(@PathVariable("id") int id) {
		Person person = (Person) repo.getPersonByID(id);
		if (person==null) throw new ResourceNotFoundException("Id not found in the request");
		return person;
	}
	
	/* same as above method, but is mapped to
	 * /api/person?id= rather than /api/person/{id}
	 */
	@RequestMapping(value="/personalt/{id}")
	@ResponseBody
	public Person getByIdFromParam(@PathVariable("id") int id) {
		return repo.getPersonByID(id);
	}
	
}
