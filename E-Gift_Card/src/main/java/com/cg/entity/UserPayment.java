package com.cg.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="payment")
public class UserPayment {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name="paymentid")
	private int paymentid ;
	@Column (name="paymentdate")
	@Temporal(TemporalType.DATE)
	private Date paymentdate=new Date(System.currentTimeMillis());
	@Column(name="paymentamount")
	@NotNull
	private float paymentamount;
	@Column(name="nameonthecard")
	@NotEmpty
	@Size(min=3,message="name should be of minimum 3 character")
	private String nameonthecard;
	@Column(name="cardNumber")
	@NotEmpty
	private String cardNumber;
	@Column(name="cardexpiry")
	@NotEmpty
	private String cardexpiry;
	@Column(name="cvv")
	@NotEmpty
	private String cvv;
	@Column(name="userGiftId")
	@NotNull
	private int  userGiftId;
	@ManyToOne(cascade=CascadeType.MERGE)
	private User users;
	public UserPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public float getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(float paymentamount) {
		this.paymentamount = paymentamount;
	}
	public String getNameonthecard() {
		return nameonthecard;
	}
	public void setNameonthecard(String nameonthecard) {
		this.nameonthecard = nameonthecard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardexpiry() {
		return cardexpiry;
	}
	public void setCardexpiry(String cardexpiry) {
		this.cardexpiry = cardexpiry;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public int getUserGiftId() {
		return userGiftId;
	}
	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "UserPayment [paymentid=" + paymentid + ", paymentdate=" + paymentdate + ", paymentamount="
				+ paymentamount + ", nameonthecard=" + nameonthecard + ", cardNumber=" + cardNumber + ", cardexpiry="
				+ cardexpiry + ", cvv=" + cvv + ", userGiftId=" + userGiftId + ", users=" + users + "]";
	}
	public UserPayment(int paymentid, Date paymentdate, @NotNull float paymentamount,
			@NotEmpty @Size(min = 3, message = "name should be of minimum 3 character") String nameonthecard,
			@NotEmpty String cardNumber, @NotEmpty String cardexpiry, @NotEmpty String cvv, @NotNull int userGiftId,
			User users) {
		super();
		this.paymentid = paymentid;
		this.paymentdate = paymentdate;
		this.paymentamount = paymentamount;
		this.nameonthecard = nameonthecard;
		this.cardNumber = cardNumber;
		this.cardexpiry = cardexpiry;
		this.cvv = cvv;
		this.userGiftId = userGiftId;
		this.users = users;
	}
	
	

}
