package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Data", catalog = "a12_DA3", schema = "db_accessadmin")
@NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d")
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String fileName;
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	public Data(){
		
	}
	
	public Data(String fileName){
		//this.id = id;
		this.fileName = fileName;
	}
	
	public int getID(){
		return id;
	}

	public String getName() {
		return fileName;
	}

	public void setName(String fileName) {
		this.fileName = fileName;
	}
	
	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}

	//TODO EDIT THIS
	@Override
	public String toString() {
		return "File [name=" + fileName +"]";
	}
}
