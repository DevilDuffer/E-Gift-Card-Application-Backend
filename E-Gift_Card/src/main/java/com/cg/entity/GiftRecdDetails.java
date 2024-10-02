package com.cg.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "giftrecddetails")
public class GiftRecdDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recdId;

	@NotNull
	private int serialNumber = 2;

	@Temporal(TemporalType.DATE)
	private Date giftReceivedDate = new Date(System.currentTimeMillis());

	@NotNull
	private boolean giftRedeemStatus = false;

	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "Gift_Id")
	private GiftCard gift;
}
