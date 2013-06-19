package entity;
 
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "Person", catalog = "a12_DA3", schema = "db_accessadmin")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
})
@XmlRootElement
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;
	private int age;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="fk_role", referencedColumnName = "id")
	@JoinTable(	name="JND_Person_Role", catalog = "a12_DA3", schema = "db_accessadmin",
					joinColumns= @JoinColumn(name="fk_Person"),
					inverseJoinColumns = @JoinColumn(name="fk_Role"))
	private List<Role> roles;
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL)
	private List<Data> datas;
	
	public void setId(int id){
		this.id = id;
	}

	
	public Person(){
		
	}
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public int getID(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<Role> getRoles(){
		return roles;
	}
	
	public void setRoles(List<Role> roles){
		this.roles = roles;
	}

	public void setData(List<Data> datas){
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}



}