package com.fire.PP2;

import javax.swing.JOptionPane;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;
	// this will check whether a card is valid
	public static Boolean isValidCard(String number){
		return validating.aValidNumber(number);

	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){

		return null;

	}// end of the createHashCode method


     // it adds a new customer to the array of customers once the payment was successful
 	 public static void addCustomer(String fName, String lName, int id, double amount, CreditCard card){
		customers[Customer.getNoOfCustomer()]= new Customer(fName,lName,id,amount, card);
 	 } // end of the addCustomer method


	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){
		String message = "Credit Card\n";
		for (int i = 0; i < customers.length;i++) 
			message += customers[i].toString()+"\n";
		JOptionPane.showMessageDialog(null, message);
	}// end of the displayStat method


	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile(){

    } // end of the writeToFile method
    private static Boolean checkInt(String number){
		  try {
		   Integer.parseInt(number);
		  }catch (NumberFormatException e){
		   return false;
		  }
		  return true;
		 }

	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) {
		hashing = new HashCode();
		validating = new  Validation();
               // input the number of customers and store it into variable n
        String number= JOptionPane.showInputDialog("how many customer you want to input?");
        while(!checkInt(number)){
			JOptionPane.showMessageDialog(null, "Wrong number! Please enter a integer!");
			number= JOptionPane.showInputDialog("how many customer you want to input?");
        }
        int n = Integer.parseInt(number);// must hold the number of customers based on the user input
		customers = new Customer [n];
		for (int i=0; i<n;i++) {
			String fName= JOptionPane.showInputDialog("enter your First Name");
			String lName= JOptionPane.showInputDialog("enter your Last Name");
			int customerId=Integer.parseInt(JOptionPane.showInputDialog("enter your Customer Id"));
			String card = JOptionPane.showInputDialog("enter your Card Id");
			isValidCard(card);
			int cardId = Integer.parseInt(card);
			CreditCard card1= new CreditCard(cardId,"");
			double amount = Double.parseDouble(JOptionPane.showInputDialog("enter your amount"));
			addCustomer(fName,lName,customerId,amount,card1);
		}//end for
        displayStat();
	}

}
