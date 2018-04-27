package com.fire.PA08;

//add the class template

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class StaffClient extends JFrame implements ActionListener{


	private String hostname;
	private int port;
	private Message msg;
	
	private  final int VIEW_OP = 0;
	private final int INSERT_OP = 1;
	private  final int UPDATE_OP = 2;
	private  final int DELETE_OP = 3;
	private Socket clientSocket;
	 ObjectOutputStream clientOutputStream;
	 ObjectInputStream clientInputStream;
	
//declare UI component objects
 
	private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JTextField field5;
    private JTextField field6;
    private JTextField field8;
    private JTextField field9;
    private JTextField field10;
    private JTextField field11;
    
    private JComboBox combList;
    
    private JButton ViewButton;
    private JButton InsertButton;
    private JButton UpdateButton;
    private JButton DeleteButton;
    private JButton ClearButton;
    private JButton CloseButton;
    
    

  public StaffClient(String hostname,int port) throws UnknownHostException, IOException {
  	
	this.hostname=hostname;
  	this.port=port;
     	
	// Create a connection with the StaffServer server on port number 8000
	
       clientSocket= new Socket(hostname,port);
       clientOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
       clientInputStream = new ObjectInputStream(clientSocket.getInputStream());
      
		
	// call these two methods to create user GUI
	initComponenet();
	doTheLayout();
	
}

private void initComponenet(){
	// Initialize the GUI components
	label1 = new JLabel("ID");
    label2 = new JLabel("Last Name    ");
    label3 = new JLabel("First Name");
    label4 = new JLabel("mi");
    label5 = new JLabel("Address        ");
    label6 = new JLabel("City              ");
    label7 = new JLabel("      State");
    label8 = new JLabel("Mobile Phone Number");
    label9 = new JLabel("Mobile Phone Carrier");
    label10 = new JLabel("Home Phone Number ");
    label11 = new JLabel("Home Phone Carrier ");
    label12 = new JLabel("Database Connected");
    
    field1 = new JTextField(10);
    field2 = new JTextField(10);
    field3 = new JTextField(10);
    field4 = new JTextField(3);
    field5 = new JTextField(20);
    field6 = new JTextField(8);
    field8 = new JTextField(8);
    field9 = new JTextField(8);
    field11 = new JTextField(8);
    field10 = new JTextField(8);
    


    String[] listStates = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
    						"Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
    						"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",         
    						"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
    						"Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
    						"Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
    						"New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
    						"Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
    						"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
    						"Wisconsin", "Wyoming" };
    
    combList = new JComboBox(listStates);

    ViewButton = new JButton("View");
    InsertButton = new JButton("Insert");
    UpdateButton = new JButton("Update");
    DeleteButton = new JButton("Delete");
    ClearButton = new JButton("Clear");
    CloseButton = new JButton("Close");
    
    ViewButton.addActionListener(this);
    InsertButton.addActionListener(this);
    UpdateButton.addActionListener(this);
    DeleteButton.addActionListener(this);
    ClearButton.addActionListener(this);
    CloseButton.addActionListener(this);

}


private void doTheLayout(){
	
	// Arrange the UI components into GUI window
	JPanel top = new JPanel(new GridLayout(0,1));
	
	 Border loweredbevel, Compound;
    TitledBorder title;
    int eb =10;
    loweredbevel= BorderFactory.createLoweredBevelBorder();
    
    title = BorderFactory.createTitledBorder(loweredbevel, "Staff Information");
    title.setTitlePosition(TitledBorder.ABOVE_TOP);
    Compound = BorderFactory.createCompoundBorder(
    	    BorderFactory.createEmptyBorder(eb, eb, eb, eb), // outer border
    	   new TitledBorder(title));
    
    top.setBorder(Compound);
    
    JPanel top1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel top2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel top3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel top4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel top5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel top6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    JPanel lower = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    top1.add(label1);
    top1.add(field1);
    
    top2.add(label2);
    top2.add(field2);
    top2.add(label3);
    top2.add(field3);
    top2.add(label4);
    top2.add(field4);
    
    top3.add(label5);
    top3.add(field5);
    
    top4.add(label6);
    top4.add(field6);
    top4.add(label7);
    top4.add(combList);
    
    top5.add(label8);
    top5.add(field8);
    top5.add(label9);
    top5.add(field9);
    
    top6.add(label10);
    top6.add(field10);
    top6.add(label11);
    top6.add(field11);
    
    lower.add(ViewButton);
    lower.add(InsertButton);
    lower.add(UpdateButton);
    lower.add(DeleteButton);
    lower.add(ClearButton);
    lower.add(CloseButton);
    
    bottom.add(label12);
    
    setLayout( new BorderLayout());
    top.add(top1);
    top.add(top2);
    top.add(top3);
    top.add(top4);
    top.add(top5);
    top.add(top6);
    this.add(top, "North");
    this.add(lower, "Center");
    this.add(bottom, "South");
    
		
	}	
		


//@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == ViewButton)
		try {
			viewButtonClicked();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	else if (e.getSource() == InsertButton)
		try {
			insertButtonClicked();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	else if (e.getSource() == UpdateButton)
		try {
			updateButtonClicked();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	else if (e.getSource() == DeleteButton)
		try {
			deleteButtonClicked();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	else if (e.getSource() == ClearButton)
		try {
			clearButtonClicked();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	else if (e.getSource() == CloseButton)
		try {
			closeButtonClicked();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
}
	

private void viewButtonClicked() throws ClassNotFoundException, IOException {
	  //handle Button View Clicked event.
	
	int id = 0;
	String Id = field1.getText().trim();
	if (Id.isEmpty()||Id.matches("^\\s*$")){
		JOptionPane.showMessageDialog(null, "Please enter Valide ID.");
		return;
	}
	try{
		id=Integer.parseInt(Id);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ID should be a number!");
		}
	
	msg = new Message(id);
}  
	
//Insert
private void insertButtonClicked() throws ClassNotFoundException, IOException{
	  
	  //handle Button View Clicked event.
	int id = 0, mPhoneNum = 0, hPhoneNum = 0;
	char mi;
	String Id = field1.getText().trim();
	String lastName = field2.getText().trim();
	String firstName = field3.getText().trim();
	String Mi = field4.getText().trim();
	String address = field5.getText().trim();
	String city = field6.getText().trim();
	String mPhone = field8.getText().trim();
	String mPhoneC = field9.getText().trim();
	String hPhone = field10.getText().trim();
	String hPhoneC = field11.getText().trim();
	
	String state = (String) combList.getSelectedItem();
  // validation,  can not be empty.
	 if (Id.isEmpty()||lastName.isEmpty() || firstName.isEmpty()||Mi.isEmpty() 
			 ||address.isEmpty() || city.isEmpty()||state.isEmpty()
			 ||mPhone.isEmpty()||mPhoneC.isEmpty()
			 ||hPhone.isEmpty()||hPhoneC.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please enter all required fields.");
	        return;
	  	    }  
//validate ID , should be number, can not be all space .
	    if(Id.matches("^\\s*$")){
	    	JOptionPane.showMessageDialog(null,"ID cannot be space");
			return;
	    }
		try{
		id=Integer.parseInt(Id);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ID should be a number!");
		}
	    
// validate last name, can not be  all space.
		
		if(lastName.length()>15){
			JOptionPane.showMessageDialog(null,"The length of last name should be no more than 15 letters");
			return;
		}
			else if (lastName.matches("^\\s*$")){
			JOptionPane.showMessageDialog(null,"The length of last name should be no more than 15 letters");
		    return;
			}
//	
		if(firstName.length()>15){
			JOptionPane.showMessageDialog(null,"The length of first name should be no more than 15 digits");
			return;
		}
		if(Mi.length()>1){
			JOptionPane.showMessageDialog(null,"The length of mi should be only 1 character");
			return;
		}
		mi = field4.getText().charAt(0);
//	
		
		if(address.length()>20){
			JOptionPane.showMessageDialog(null,"The length of address should be no more than 20 characters");
			return;
		}
		
//
		if(city.length()>20){
			JOptionPane.showMessageDialog(null,"The length of city should be no more than 20 characters");
			return;
		}


		
		if(mPhone.length()!=10){
			JOptionPane.showMessageDialog(null,"Mobile phone  should be 10 digits number");
			return;
		}
		try{
		mPhoneNum = Integer.parseInt(mPhone);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Plese input only numbers.");
		}
	    
		//
		if(hPhone.length()!=10){
			JOptionPane.showMessageDialog(null,"Home phone should be 10 digits number");
			return;
		}
		try{
		hPhoneNum = Integer.parseInt(hPhone);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Home phone should be Integer number!");
		}
		
		//
		if(mPhoneC.matches("^\\s*$")){
	    	JOptionPane.showMessageDialog(null,"Mobile Carrier cannot be all spaces");
			return;
			}
			else if (mPhoneC.length()>20) {
				JOptionPane.showMessageDialog(null,"The length of city should be no more than 20 characters");
				return;
	    }
		
		//
		if(hPhoneC.matches("^\\s*$")){
	    	JOptionPane.showMessageDialog(null,"Mobile Carrier cannot be all spaces");
			return;
			}
			else if (hPhoneC.length()>20) {
				JOptionPane.showMessageDialog(null,"The length of city should be no more than 20 characters");
				return;
	    }
	

//	sendMessage(id,lastName,firstName,mi,address,city, state,
//			mPhoneNo, hPhoneNo, mPhoneCarrier,hPhoneCarrier,INSERT_OP);

		msg = new Message(id,lastName,firstName,mi,address,city, state,
				mPhoneNum, hPhoneNum, mPhoneC,hPhoneC,INSERT_OP);	
		sendMessage();
}  
	

private void updateButtonClicked() throws ClassNotFoundException, IOException{
	  //handle Button View Clicked event.
	  //handle Button View Clicked event.
	int id = 0, mPhoneNum = 0, hPhoneNum = 0;
	char mi;
	String idString = field1.getText().trim();
	String address = field5.getText().trim();

	 if (idString.isEmpty()||address.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please enter required fields.");
	        return;
	  	    }  
//	   
	    if(idString.matches("^\\s*$")){
	    	JOptionPane.showMessageDialog(null,"ID cannot be space");
			return;
	    }
		try{
		id=Integer.parseInt(idString);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ID should be a number!");
		}
	    
		if(address.length()>20){
			JOptionPane.showMessageDialog(null,"The length of address should be no more than 20 characters");
			return;
		}
		
// just update address.
	msg = new Message(id);
	msg.setOrder(UPDATE_OP);
	msg.setAddress(address);
	sendMessage();
}  
	
	


private void deleteButtonClicked() throws ClassNotFoundException, IOException{
	  //handle Button delete Clicked event.
	int id = 0;
	String idString = field1.getText().trim();
	if (idString.isEmpty()||idString.matches("^\\s*$")){
		JOptionPane.showMessageDialog(null, "Please enter Valide ID.");
		return;
	}
	try{
		id=Integer.parseInt(idString);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ID should be a number!");
		}
	
	msg = new Message(id);
	msg.setOrder(DELETE_OP);
	sendMessage();
	
}  

void clearButtonClicked() throws ClassNotFoundException, IOException{
	  //handle Button Clear Clicked event.
	field1.setText("");
	field2.setText("");
	field3.setText("");
	field4.setText("");
	field5.setText("");
	field6.setText("");
	field8.setText("");
	field9.setText("");
	field10.setText("");
	field11.setText("");
	
}  
	


void closeButtonClicked() throws ClassNotFoundException, IOException{
	  //handle Button Close Clicked event.
	clientSocket.close();
	clientOutputStream.close();
	clientInputStream.close();
	
	System.exit(0);
}  
public void sendMessage() throws IOException, ClassNotFoundException {	
	
	clientOutputStream.writeObject(msg);
   	receivingMessage();
	
	}

	
private void receivingMessage() throws IOException, ClassNotFoundException {
    	
		msg = (Message)clientInputStream.readObject();
		
		switch(msg.getOrder()){
		case VIEW_OP:
			if(msg.getId()!=0) {
				field1.setText(String.valueOf(msg.getId()));
				field2.setText(msg.getLastName());
				field3.setText(msg.getFirstFName());
				field4.setText(String.valueOf(msg.getMi()));
				field5.setText(msg.getAddress());
				field6.setText(msg.getCity());
				field8.setText(String.valueOf(msg.getmPhoneNo()));
				field9.setText(msg.getmPhoneCarrier());
				field10.setText(String.valueOf(msg.gethPhoneNo()));
				field11.setText(msg.gethPhoneCarrier());
				combList.setSelectedItem(msg.getState());
			}else
				JOptionPane.showMessageDialog(null,msg.getMsg());
			break;
		case 1:
			if(msg.getId()!=0)
				JOptionPane.showMessageDialog(null,"Insert succeed!");
			else
				JOptionPane.showMessageDialog(null,"Insert fail!\n" + msg.getMsg());
		    break;
		case 2:
			if(msg.getId()!=0)
				JOptionPane.showMessageDialog(null,"Update succeed!");
			else
				JOptionPane.showMessageDialog(null,"Update fail!\n" + msg.getMsg());
		    break;
		case 3:
			if(msg.getId()!=0)
				JOptionPane.showMessageDialog(null,"Delete succeed!");
			else
				JOptionPane.showMessageDialog(null,"Delete fail!" + msg.getMsg());
		    break;
		}
		
		
	}

/**Main method
 * @throws IOException 
 * @throws UnknownHostException */
public static void main(String[] args) {  
	  // create the user GUI
	JFrame StaffGui = null;
	  try {
		StaffGui = new StaffClient("BusCISMySQL01",3306);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Cannot conected to Server. Please try agian");
        System.exit(0);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Cannot conected to Server. Please try agian");
        System.exit(0);
	}  
    StaffGui.setTitle("Staff Table GUI");
    StaffGui.pack();
    StaffGui.setLocationRelativeTo(null); // Center the frame
    StaffGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    StaffGui.setVisible(true);
}
}