package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class UserPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentid")
	private int paymentid;

	@Column(name = "paymentdate")
	@Temporal(TemporalType.DATE)
	private Date paymentdate = new Date(System.currentTimeMillis());

	@Column(name = "paymentamount")
	@NotNull
	private float paymentamount;

	@Column(name = "nameonthecard")
	@NotEmpty
	@Size(min = 3, message = "name should be of minimum 3 character")
	private String nameonthecard;

	@Column(name = "cardNumber")
	@NotEmpty
	private String cardNumber;

	@Column(name = "cardexpiry")
	@NotEmpty
	private String cardexpiry;

	@Column(name = "cvv")
	@NotEmpty
	private String cvv;

	@Column(name = "userGiftId")
	@NotNull
	private int userGiftId;

	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;
}
