package PP4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
