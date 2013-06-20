package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;



@Entity
@Table(name = "Role", catalog = "a12_DA3", schema = "db_accessadmin")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	int id;
	String roleName;
	@JsonIgnore
	@ManyToMany(mappedBy="roles",cascade=CascadeType.PERSIST)
	private List<Person> personList;
	
	public Role(){
		
	}
	
	public Role(String roleName){
		this.roleName = roleName;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@XmlTransient
	public List<Person> getPersonList(){
		return personList;
	}
	public void setPersonList(List<Person> list){
		this.personList = list;
	}
}
