package com.cg.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="firstname")
	@NotEmpty
	@Size(min=3,message="First Name Should be of min 3 Character")
	private String firstname;
	@Column(name = "lastname")
	@NotEmpty
	@Size(min=3,message="Last Name Should be of min 3 Character")
	private String lastname;
	@Column(name = "email")
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	@Column(name = "phonenumber")
	@NotEmpty
	private String phonenumber;
	@Column(name = "password")
	@NotEmpty
	private String password;
	@Column(name= "address")
	@NotEmpty
	private String address;
	@JsonIgnore
	@ManyToMany(mappedBy="users",cascade=CascadeType.ALL)
	private List<GiftCard> gifts;
	@OneToMany(mappedBy="users",cascade=CascadeType.ALL)
	private List<UserPayment> payments;
	
	@OneToMany(mappedBy="users",cascade=CascadeType.ALL)
	private List<GiftRecdDetails> receives ;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<GiftCard> getGifts() {
		return gifts;
	}

	public void setGifts(List<GiftCard> gifts) {
		this.gifts = gifts;
	}

	public List<UserPayment> getPayments() {
		return payments;
	}

	public void setPayments(List<UserPayment> payments) {
		this.payments = payments;
	}

	public List<GiftRecdDetails> getReceives() {
		return receives;
	}

	public void setReceives(List<GiftRecdDetails> receives) {
		this.receives = receives;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", password=" + password + ", address=" + address + ", gifts="
				+ gifts + ", payments=" + payments + ", receives=" + receives + "]";
	}

	public User(int id, @NotEmpty @Size(min = 3, message = "First Name Should be of min 3 Character") String firstname,
			@NotEmpty @Size(min = 3, message = "Last Name Should be of min 3 Character") String lastname,
			@NotEmpty @Email(message = "Email Address is not Valid!") String email, @NotEmpty String phonenumber,
			@NotEmpty String password, @NotEmpty String address, List<GiftCard> gifts, List<UserPayment> payments,
			List<GiftRecdDetails> receives) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
		this.gifts = gifts;
		this.payments = payments;
		this.receives = receives;
	}
	
	
	
}