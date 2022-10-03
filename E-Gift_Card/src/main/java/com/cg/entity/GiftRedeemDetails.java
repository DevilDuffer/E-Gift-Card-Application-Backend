//package com.cg.entity;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class GiftRedeemDetails {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int giftReceivedId;
//	@Temporal(TemporalType.DATE)
//	private Date giftReceivedDate=new Date(System.currentTimeMillis());
//	@NotEmpty
//	private String giftRedeemStatus;
//	@NotEmpty
//	private String giftRedemAmount;
//	private float balance;
//	@NotNull
//	private float maximummount;
//	@NotNull
//	private int userGiftId;
//	@OneToOne()
//	private GiftRecdDetails receives;
//	public GiftRedeemDetails() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public int getGiftReceivedId() {
//		return giftReceivedId;
//	}
//	public void setGiftReceivedId(int giftReceivedId) {
//		this.giftReceivedId = giftReceivedId;
//	}
//	public Date getGiftReceivedDate() {
//		return giftReceivedDate;
//	}
//	public void setGiftReceivedDate(Date giftReceivedDate) {
//		this.giftReceivedDate = giftReceivedDate;
//	}
//	public String getGiftRedeemStatus() {
//		return giftRedeemStatus;
//	}
//	public void setGiftRedeemStatus(String giftRedeemStatus) {
//		this.giftRedeemStatus = giftRedeemStatus;
//	}
//	public String getGiftRedemAmount() {
//		return giftRedemAmount;
//	}
//	public void setGiftRedemAmount(String giftRedemAmount) {
//		this.giftRedemAmount = giftRedemAmount;
//	}
//	public float getBalance() {
//		return balance;
//	}
//	public void setBalance(float balance) {
//		this.balance = balance;
//	}
//	public float getMaximummount() {
//		return maximummount;
//	}
//	public void setMaximummount(float maximummount) {
//		this.maximummount = maximummount;
//	}
//	public int getUserGiftId() {
//		return userGiftId;
//	}
//	public void setUserGiftId(int userGiftId) {
//		this.userGiftId = userGiftId;
//	}
//	@Override
//	public String toString() {
//		return "GiftRedeemDetails [giftReceivedId=" + giftReceivedId + ", giftReceivedDate=" + giftReceivedDate
//				+ ", giftRedeemStatus=" + giftRedeemStatus + ", giftRedemAmount=" + giftRedemAmount + ", balance="
//				+ balance + ", maximummount=" + maximummount + ", userGiftId=" + userGiftId + "]";
//	}
//	public GiftRedeemDetails(int giftReceivedId, Date giftReceivedDate, @NotEmpty String giftRedeemStatus,
//			@NotEmpty String giftRedemAmount, float balance, @NotNull float maximummount, @NotNull int userGiftId) {
//		super();
//		this.giftReceivedId = giftReceivedId;
//		this.giftReceivedDate = giftReceivedDate;
//		this.giftRedeemStatus = giftRedeemStatus;
//		this.giftRedemAmount = giftRedemAmount;
//		this.balance = balance;
//		this.maximummount = maximummount;
//		this.userGiftId = userGiftId;
//	}
//	
//}
