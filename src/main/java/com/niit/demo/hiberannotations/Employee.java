package com.niit.demo.hiberannotations;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	private int id;
	private String firstname,lastname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
