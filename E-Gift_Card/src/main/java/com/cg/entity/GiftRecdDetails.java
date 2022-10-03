package com.cg.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="giftrecddetails")
public class GiftRecdDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int recdId;
	@NotNull
	private int serialNumber=2;
	@Temporal(TemporalType.DATE)
	private Date giftReceivedDate=new Date(System.currentTimeMillis());
	@NotNull
	private boolean giftRedeemStatus=false;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private User users;
	@ManyToOne(cascade=CascadeType.MERGE)
	private GiftCard gifts;
//	@OneToOne(mappedBy="receives",cascade=CascadeType.ALL)
//	private GiftRedeemDetails redeems;
	public GiftRecdDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRecdId() {
		return recdId;
	}
	public void setRecdId(int recdId) {
		this.recdId = recdId;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getGiftReceivedDate() {
		return giftReceivedDate;
	}
	public void setGiftReceivedDate(Date giftReceivedDate) {
		this.giftReceivedDate = giftReceivedDate;
	}
	public boolean isGiftRedeemStatus() {
		return giftRedeemStatus;
	}
	public void setGiftRedeemStatus(boolean giftRedeemStatus) {
		this.giftRedeemStatus = giftRedeemStatus;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public GiftCard getGifts() {
		return gifts;
	}
	public void setGifts(GiftCard gifts) {
		this.gifts = gifts;
	}
	@Override
	public String toString() {
		return "GiftRecdDetails [recdId=" + recdId + ", serialNumber=" + serialNumber + ", giftReceivedDate="
				+ giftReceivedDate + ", giftRedeemStatus=" + giftRedeemStatus + ", users=" + users + ", gifts=" + gifts
				+ "]";
	}
	public GiftRecdDetails(int recdId, @NotNull int serialNumber, Date giftReceivedDate,
			@NotNull boolean giftRedeemStatus, User users, GiftCard gifts) {
		super();
		this.recdId = recdId;
		this.serialNumber = serialNumber;
		this.giftReceivedDate = giftReceivedDate;
		this.giftRedeemStatus = giftRedeemStatus;
		this.users = users;
		this.gifts = gifts;
	}
	
	
	
}
