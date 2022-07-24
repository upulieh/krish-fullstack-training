package com.upulie.rentcloud.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	//each of the names of fields,setters and getters should match this exact convention (this is how the table columns are created)
	//(case sensitive)
	@Id
	@GeneratedValue
	int id;
	String firstname;
	String lastname;
	String dlnumber;
	String zipcode;
	
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
	public String getDlnumber() {
		return dlnumber;
	}
	public void setDlnumber(String dlnumber) {
		this.dlnumber = dlnumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
