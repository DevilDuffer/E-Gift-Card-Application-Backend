package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	@NotEmpty
	@Size(min = 3, message = "First Name Should be of min 3 Character")
	private String firstname;

	@Column(name = "lastname")
	@NotEmpty
	@Size(min = 3, message = "Last Name Should be of min 3 Character")
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

	@Column(name = "address")
	@NotEmpty
	private String address;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_gift_association", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "gift_card_id"))
	private List<GiftCard> gifts = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserPayment> payments;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<GiftRecdDetails> receives;
	
	public void addGiftCard(GiftCard giftCard) {
        this.gifts.add(giftCard);
        giftCard.getUsers().add(this); // Maintain synchronization
    }

    public void removeGiftCard(GiftCard giftCard) {
        this.gifts.remove(giftCard);
        giftCard.getUsers().remove(this); // Maintain synchronization
    }
}