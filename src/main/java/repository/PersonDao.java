package repository;
 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entity.Person;
 
@Component
public class PersonDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Persist
    @Transactional
    public void persist(Person person) {
        em.persist(person);
    }
 
    // Find
    public Person getPersonByID(int id){
    	Person person = em.find(Person.class, id);
    	if (person !=null){
    		return person;
    	}
    	return null; 
    }
    
    // TypedQuery
    public List<Person> getAllPersons() {
        TypedQuery<Person> query = em.createQuery(
            "SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }
    
    // NamedQuery => more efficient because the persistence provider translates the JPSQL -> SQL on app startup
    public Person getPersonByName(String name){
    	try {
	    	Query q = em.createNamedQuery("Person.findByName");
	    	q.setParameter("name", name);
	    	return (Person) q.getResultList().get(0);
	    	
    	} catch(NoResultException e) {
            return null;
        }
    }
}