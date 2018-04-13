package com.fire.PP3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UserGUI extends JPanel {
	
	
	  private JButton scrapeButton;
	  private JButton closeButton;
	  // add more UI components as needed
	  private Scraper scraper;
	
	
	  private String url;

	  private Pattern pattern1 = Pattern.compile(".*</tbody>.*"); //end
      private Pattern pattern2 = Pattern.compile("<td class=\"tbdy1\"><a href=\"/teams(.*?)</a></td></tr>"); //end of every player and signal for team
      private Pattern pattern3 = Pattern.compile("^<td><a href=\"/player(.*?)</a></td>");//signal for player's name
      private Pattern pattern4 = Pattern.compile("^<td class=\"tbdy\">[A-Z][A-Z]</td>");//signal for player's position
      private Pattern pattern5 = Pattern.compile("^<td class=\"tbdy\">[\\d]*+</td>");	//signal for player's number
      private Pattern pattern6 = Pattern.compile("<td class=\"tbdy\">[\\d.-]*+</td>");//signal for player's TCKL, SCK, INT

	  public UserGUI() {
		 
		  // uses the url provided in the document
		 Scraper scraper = new Scraper(url);

	    initGUI();
	    doTheLayout();

	    scrapeButton.addActionListener( new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            scrape();
	            }
	    });
	    
	    closeButton.addActionListener( new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            close();
	            }
	    });
	    
	   
	  } // end of constructor

	  
	  // Creates and initialize the GUI objects
	  private void initGUI(){
	  
	  }// end of creating objects method

	
	  // Layouts the UI components as shown in the project document
	  private void doTheLayout(){

	  }// end of Layout method

	 
	// Uses the Scraper object reference to return and display the data as shown in the project document 
	 void scrape(){
         Regex r = new Regex(pattern1,pattern2,pattern3,pattern4,pattern5,pattern6,null,null);
         Scraper s = new Scraper(this.url);

	  }// end of scrape action event method
	  
	 
	  void close(){
	      System.exit(0);
	  }// end of close action event method


	public static void main(String[] args) {
	   JFrame f = new JFrame("NFL Stats");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();
        contentPane.add( new UserGUI());
        f.pack();
        f.setVisible(true);
	}// end of main method

}// end of class
