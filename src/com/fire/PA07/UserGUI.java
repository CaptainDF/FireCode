package com.fire.PA07;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserGUI extends JFrame implements ActionListener{
	
	static Person[] personArray;
	private JLabel labelLast;
	private JLabel labelFirst;
	private JLabel labelAddress;
	private JLabel labelPhone;
	private JLabel labelMail;
	private JTextField last;
	private JTextField first;
	private JTextField address;
	private JTextField phone;
	private JTextField email;
	private JButton Add;
	private JButton Sort;
	private JButton Display;
	JRadioButton rbStudent;
	JRadioButton rbFaculty;
	ButtonGroup rbGroup;
	private JTextArea textArea;
	JList jList;
	 String[] liststudent = { "Freshman","Sophomore", "Junior", "Senior" };
     String[] listfaculty = { "Lecrturer","Assistant Professor", "Associate Professor", "Professor" };
	// declare all GUI components below
	  
				// constructor
	UserGUI(int nPersons){				
	personArray= new Person[nPersons];	
					// create person array of size nPerson
					//Initialize the components
	initComponenet();
					//Organize the GUI components
	doTheLayout();				
					/*Add the action listeners GUI buttons(add, sort, and display)
					Example: addButton.addActionListener(this);*/
	Add.addActionListener(this);	
	Sort.addActionListener(this);
	Display.addActionListener(this);
	rbStudent.addActionListener(this);
	rbFaculty.addActionListener(this);
				}//End of constructor

	private void initComponenet(){
		labelLast = new JLabel("last name");
		last = new JTextField(40);
		labelFirst = new JLabel("First name");
		first = new JTextField(40);
		labelAddress = new JLabel("Address");
		address = new JTextField(40);
		labelPhone = new JLabel("Phone");
		phone = new JTextField(40);
		labelMail = new JLabel("eMail");
		email = new JTextField(40);
		
		rbStudent=new JRadioButton("student",true);  
        rbFaculty=new JRadioButton("faculty",false);
        rbGroup  = new ButtonGroup();
        rbGroup.add(rbFaculty);
        rbGroup.add(rbStudent);
       
        jList = new JList();
        	jList.setListData(liststudent);
    		jList.setSelectedIndex(0);
        
	    

		Add = new JButton("Add Student/Faculty");
		Sort =  new JButton("Sort Student/ Faculty");
		Display = new JButton("Display Student/Faculty");
		
		textArea = new JTextArea("Program output\n",7,48);
		textArea.setEditable(false);
		//buttons
		
		 // initialize all user interface components
				      
			  
		}

	private void doTheLayout(){
					// Organize the components into GUI window
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		JPanel centerTop = new JPanel();
		JPanel centerButton = new JPanel();
		JPanel bottom = new JPanel();
		
		top.setLayout( new GridLayout(6,2));
		top.add(labelLast);
		top.add(last);
		top.add(labelFirst);
		top.add(first);
		top.add(labelAddress);
		top.add(address);
		top.add(labelPhone);
		top.add(phone);
		top.add(labelMail);
		top.add(email);
		
		centerTop.add(rbFaculty);
		centerTop.add(rbStudent);
		centerTop.add(jList);
		centerTop.setSize(200, 75);
		
		center.setLayout(new GridLayout(2,1));
		center.add(centerTop, BorderLayout.NORTH);
		center.add(centerButton, BorderLayout.SOUTH);
		
		centerButton.add(Add);
		centerButton.add(Sort);
		centerButton.add(Display);
		
		bottom.add(textArea);
		
		setLayout( new BorderLayout());
	    add(top, "North");
	    add(center, "Center");
	   	add(bottom, "South");
		}

				
				@Override
	public void actionPerformed(ActionEvent e) {
					// Call the required button action method according to the action event
				if(e.getSource()== Add) 
					addButtonClicked();
				else if (e.getSource()== Sort)
					sortBnttonClicked();
				else if(e.getSource()==Display)
					try {
						displaynttonClicked();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else if(e.getSource() == rbFaculty) {
					jList.setListData(listfaculty);
					jList.setSelectedIndex(0);
					System.out.println("Jlist " + jList.getSize());
				} else if(e.getSource() == rbStudent) {
					jList.setListData(liststudent);
					jList.setSelectedIndex(0);
					System.out.println("Jlist " + jList.getSize());
				}
}
			   
	private void addButtonClicked(){		
		if(!last.getText().trim().isEmpty()
			&&!first.getText().trim().isEmpty()
			&&!address.getText().trim().isEmpty()
			&&!phone.getText().trim().isEmpty()
			&&!email.getText().trim().isEmpty()) {
			if(Person.getNumberOfPersons()<personArray.length) {
				if(rbStudent.isSelected()) {
					String[] s =  address.getText().split(",");
					Address ss = new Address(s[0],Integer.parseInt(s[1]),s[2],s[3],Integer.parseInt(s[4]));
					String status = jList.getSelectedValue().toString();
					personArray[Person.getNumberOfPersons()] = new Student(first.getText().trim(), last.getText().trim(), 
							ss, phone.getText().trim(), email.getText().trim(), status);
					}
				else if(rbFaculty.isSelected()) {
					String rankOfFaculty = jList.getSelectedValue().toString();
					//personArray[Person.getNumberOfPersons()]= new Faculty(first.getText().trim(),last.getText().trim(),ss,phone.getText().trim(),email.getText().trim(),rankOfFaculty,new MyDate());
				}
				last.setText("");
				first.setText("");
				address.setText("");
				phone.setText("");
				email.setText("");
			}
		}
		}
					//Method to implement add button action
				

						
	private void sortBnttonClicked() {
		
		selectionSort();//Method to implement sort button action
				}

	private void displaynttonClicked() throws FileNotFoundException{
		textArea.setText("");
		String displayText = "";
		for(int i = 0; i < Person.getNumberOfPersons(); i++) {
			displayText = displayText.concat(personArray[i].toString() + "\n");
		}
		textArea.setText(displayText);

	}

				
				
	private void selectionSort() {
		for(int i = 0; i < Person.getNumberOfPersons(); i++) {
			for(int j = 0; j < Person.getNumberOfPersons()-1; j++) {
				Arrays.sort(personArray, new Comparator<Person>() {
					@Override
					public int compare(Person first, Person second){
						if(second == null || first == null)
							return 0;
						else
							return first.getLastName().compareTo(second.getLastName());
					}
				} );
			}
		}//Method to sort person objects based on last name	
				}
				
						
	public static void main(String[] args) throws FileNotFoundException {
			
				String numberOfPersons = JOptionPane.showInputDialog("Enter number of persons, example,enter a value of 2");
				while(!checkNum(numberOfPersons)){
					JOptionPane.showMessageDialog(null, "Wrong number! Please enter a integer!");
					numberOfPersons = JOptionPane.showInputDialog("Enter number of persons again, example,enter a value of 2");
				}
				int nPersons = Integer.parseInt(numberOfPersons);
				UserGUI f = new UserGUI(nPersons);
				f.setVisible(true);
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(600, 400);
				System.out.println(f.getSize());
				f.setVisible(true);
				//Set GUI frame settings
			
			}// end main
	private static Boolean checkNum(String number){
		  try {
		   int x = Integer.parseInt(number);
		   if(x <1) return false;
		   else return true;
		  }catch (NumberFormatException e){
		   return false;
		  }
		 }
	}
