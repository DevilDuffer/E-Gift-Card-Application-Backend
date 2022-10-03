package com.cg.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="giftcard")
public class GiftCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="giftCardId")
	private int giftCardId;
	@Column(name="giftname")
	@NotEmpty
	private String giftCardName;
	@Column(name="giftbrand")
	@NotEmpty
	private String brands;
	@Column(name="redemptiondetails")
//	Random rnd = new Random();
	private double redemptionDetail=(new Random()).nextInt(999999);

	@Column(name="min_amount")
	private int minimumAmount;
	@Column(name="max_amount")
	private int maximumAmount;
	@Column(name="description")
	@NotEmpty
	private String giftCardDesc;
	@ManyToMany(cascade=CascadeType.MERGE)
	private List<User> users;
	@OneToMany(mappedBy="gifts",cascade=CascadeType.ALL)
	private List<GiftRecdDetails> receives ;
	public GiftCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGiftCardId() {
		return giftCardId;
	}
	public void setGiftCardId(int giftCardId) {
		this.giftCardId = giftCardId;
	}
	public String getGiftCardName() {
		return giftCardName;
	}
	public void setGiftCardName(String giftCardName) {
		this.giftCardName = giftCardName;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public double getRedemptionDetail() {
		return redemptionDetail;
	}
	public void setRedemptionDetail(double redemptionDetail) {
		this.redemptionDetail = redemptionDetail;
	}
	public int getMinimumAmount() {
		return minimumAmount;
	}
	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}
	public int getMaximumAmount() {
		return maximumAmount;
	}
	public void setMaximumAmount(int maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
	public String getGiftCardDesc() {
		return giftCardDesc;
	}
	public void setGiftCardDesc(String giftCardDesc) {
		this.giftCardDesc = giftCardDesc;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<GiftRecdDetails> getReceives() {
		return receives;
	}
	public void setReceives(List<GiftRecdDetails> receives) {
		this.receives = receives;
	}
	@Override
	public String toString() {
		return "GiftCard [giftCardId=" + giftCardId + ", giftCardName=" + giftCardName + ", brands=" + brands
				+ ", redemptionDetail=" + redemptionDetail + ", minimumAmount=" + minimumAmount + ", maximumAmount="
				+ maximumAmount + ", giftCardDesc=" + giftCardDesc + ", users=" + users + ", receives=" + receives
				+ "]";
	}
	public GiftCard(int giftCardId, @NotEmpty String giftCardName, @NotEmpty String brands, double redemptionDetail,
			int minimumAmount, int maximumAmount, @NotEmpty String giftCardDesc, List<User> users,
			List<GiftRecdDetails> receives) {
		super();
		this.giftCardId = giftCardId;
		this.giftCardName = giftCardName;
		this.brands = brands;
		this.redemptionDetail = redemptionDetail;
		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
		this.giftCardDesc = giftCardDesc;
		this.users = users;
		this.receives = receives;
	}
	
	
}
