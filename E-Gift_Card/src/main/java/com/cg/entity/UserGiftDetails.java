package com.cg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="usergiftdetails")
public class UserGiftDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userGiftId;
	@NotNull
	private float giftCardAmount;
	@Temporal(TemporalType.DATE)
	private Date giftCardIssueDate=new Date(System.currentTimeMillis());
	//private boolean reloadable ;
	//@NotEmpty
	private String recipientsName;
	//@NotEmpty
	private String recipientsMobileNumber;
	@NotEmpty
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String recipientsEmail;
	@NotEmpty
	private String deliveryType ;
	@Temporal(TemporalType.DATE)
	private Date scheduledeliveryDate=new Date(System.currentTimeMillis());
//	@NotNull
//	private int personalizeId ;
	
	@NotNull
	private int userId;
	@NotNull
	private int giftCardId ;
	@NotNull
	private int senderId;
	public UserGiftDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserGiftId() {
		return userGiftId;
	}
	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}
	public float getGiftCardAmount() {
		return giftCardAmount;
	}
	public void setGiftCardAmount(float giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}
	public Date getGiftCardIssueDate() {
		return giftCardIssueDate;
	}
	public void setGiftCardIssueDate(Date giftCardIssueDate) {
		this.giftCardIssueDate = giftCardIssueDate;
	}
	public String getRecipientsName() {
		return recipientsName;
	}
	public void setRecipientsName(String recipientsName) {
		this.recipientsName = recipientsName;
	}
	public String getRecipientsMobileNumber() {
		return recipientsMobileNumber;
	}
	public void setRecipientsMobileNumber(String recipientsMobileNumber) {
		this.recipientsMobileNumber = recipientsMobileNumber;
	}
	public String getRecipientsEmail() {
		return recipientsEmail;
	}
	public void setRecipientsEmail(String recipientsEmail) {
		this.recipientsEmail = recipientsEmail;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public Date getScheduledeliveryDate() {
		return scheduledeliveryDate;
	}
	public void setScheduledeliveryDate(Date scheduledeliveryDate) {
		this.scheduledeliveryDate = scheduledeliveryDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGiftCardId() {
		return giftCardId;
	}
	public void setGiftCardId(int giftCardId) {
		this.giftCardId = giftCardId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	@Override
	public String toString() {
		return "UserGiftDetails [userGiftId=" + userGiftId + ", giftCardAmount=" + giftCardAmount
				+ ", giftCardIssueDate=" + giftCardIssueDate + ", recipientsName=" + recipientsName
				+ ", recipientsMobileNumber=" + recipientsMobileNumber + ", recipientsEmail=" + recipientsEmail
				+ ", deliveryType=" + deliveryType + ", scheduledeliveryDate=" + scheduledeliveryDate + ", userId="
				+ userId + ", giftCardId=" + giftCardId + ", senderId=" + senderId + "]";
	}
	public UserGiftDetails(int userGiftId, @NotNull float giftCardAmount, Date giftCardIssueDate, String recipientsName,
			String recipientsMobileNumber,
			@NotEmpty @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") @NotEmpty(message = "Email cannot be empty") String recipientsEmail,
			@NotEmpty String deliveryType, Date scheduledeliveryDate, @NotNull int userId, @NotNull int giftCardId,
			@NotNull int senderId) {
		super();
		this.userGiftId = userGiftId;
		this.giftCardAmount = giftCardAmount;
		this.giftCardIssueDate = giftCardIssueDate;
		this.recipientsName = recipientsName;
		this.recipientsMobileNumber = recipientsMobileNumber;
		this.recipientsEmail = recipientsEmail;
		this.deliveryType = deliveryType;
		this.scheduledeliveryDate = scheduledeliveryDate;
		this.userId = userId;
		this.giftCardId = giftCardId;
		this.senderId = senderId;
	}
	
	
	
}
