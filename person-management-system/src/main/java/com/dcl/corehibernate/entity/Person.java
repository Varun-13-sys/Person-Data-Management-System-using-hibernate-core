package com.dcl.corehibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person") // Actual Table Name in SQL
public class Person {
	@Id
	@Column(name = "person_Id") // Actual Column Name in SQL
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generates the ID
	private int personId;

	@Column(name = "person_name")
	private String title;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private int age;

	@Column(name = "mobile")
	private long mobile;

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", title=" + title + ", email=" + email + ", age=" + age + ", mobile="
				+ mobile + ", city=" + city + "]";
	}

	@Column(name = "city")
	private String city;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
