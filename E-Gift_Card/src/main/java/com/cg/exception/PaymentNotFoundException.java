package com.cg.exception;

public class PaymentNotFoundException extends Exception {
	
	public String toString(PaymentNotFoundException e) {
		return "Payment Details Not Found";
	}

}
