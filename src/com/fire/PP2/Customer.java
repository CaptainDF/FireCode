package com.fire.PP2;
public class Customer {
	
	public Customer() {
		this("","",0,0.0,null);
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustomer;
	
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		noOfCustomer++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
	public static int getNoOfCustomer() {
		return noOfCustomer;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", amount=" + amount + ", card=" + card.toString()
				+ "]";
	}
	
	
	// add public setter/getter methods, and also the toString method

}
