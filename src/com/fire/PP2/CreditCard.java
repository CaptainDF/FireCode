package com.fire.PP2;

public class CreditCard {
	
	private long number;
	private String expDate;


	public CreditCard() {
		this(0,"");
		}
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}
	@Override
	public String toString() {
		return "CreditCard [number=" + number + ", expDate=" + expDate + "]";
	}
	
	// add public setter/getter methods, and also the toString method
}
