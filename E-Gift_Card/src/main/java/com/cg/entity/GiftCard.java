package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "giftcard")
public class GiftCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "giftCardId")
	private int giftCardId;

	@Column(name = "giftname")
	@NotEmpty
	private String giftCardName;

	@Column(name = "giftbrand")
	@NotEmpty
	private String brands;

	@Column(name = "redemptiondetails")
	private double redemptionDetail = (new Random()).nextInt(999999);

	@Column(name = "min_amount")
	private int minimumAmount;

	@Column(name = "max_amount")
	private int maximumAmount;

	@Column(name = "description")
	@NotEmpty
	private String giftCardDesc;

	@ManyToMany(mappedBy = "gifts", cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();

	@OneToMany(mappedBy = "gift", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<GiftRecdDetails> receives;
	
	// Add helper methods to maintain bidirectional relationship
    public void addUser(User user) {
        this.users.add(user);
        user.getGifts().add(this); // Maintain synchronization
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.getGifts().remove(this); // Maintain synchronization
    }
}
