package com.oxg.branch.documents;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Branch")
@XmlAccessorType(XmlAccessType.PROPERTY) 
@XmlRootElement(name="branch")
public class Branch implements Serializable {
	private static final long serialVersionUID = 5847343565261554861L;
	
	@Id
	private ObjectId _id;

	@Field(value="id")
	private int id;
	
	@Field(value="name")
	private String name;
	@Field(value="streetAddress")
	private String streetAddress;
	@Field(value="city")
	private String city;
	@Field(value="state")
	private String state;
	@Field(value="zipCode")
	private String zipCode;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
