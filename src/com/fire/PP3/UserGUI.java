package com.fire.PP3;

import com.sun.deploy.net.HttpUtils;
import sun.net.www.http.HttpClient;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
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
		 Scraper scraper = new Scraper(url,null);

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
         Scraper s = new Scraper(this.url,null);

	  }// end of scrape action event method
	  
	 
	  void close(){
	      System.exit(0);
	  }// end of close action event method

	public static String getPageContent(String myurl) throws MalformedURLException,IOException{//在此导入网址链接
		URL url= new URL(myurl);
		URLConnection urlConnection=   url.openConnection();
		BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String str="";
		StringBuffer content=new StringBuffer();
		while((str=br.readLine())!=null){
			content.append(str);
		}
		br.close();
		return content.toString();
	}

	public static List<String> match(String source, String element, String attr) {
		List<String> result = new ArrayList<String>();
//		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";


		System.out.println("reg="+reg);
		Matcher m = Pattern.compile(reg).matcher(source);
		while (m.find()) {
			String r = m.group(1);
			result.add(r);
		}
		return result;
	}

	public static void main(String[] args) throws Exception{
	   /*JFrame f = new JFrame("NFL Stats");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();
        contentPane.add( new UserGUI());
        f.pack();
        f.setVisible(true);*/
	   Pattern pattern = Pattern.compile("<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"(.*?)\" />");

	   Pattern p2 = Pattern.compile("<tbody>" +
			   "<tr class=\"(.*?)\">" +
			   "<td class=\"tbdy\">(.*?)</td>" +
			   "<td class=\"tbdy\"></td>" +
			   "<td><a href=\"(.*?)</a></td>" +
			   "<td class=\"tbdy\">(.*?)</td>" +
			   "<td class=\"ra\">(.*?)</td>" +
			   "<td class=\"tbdy\">(.*?)</td>" +
			   "<td class=\"ra\">(.*?)</td>" +
			   "<td class=\"tbdy\">(.*?)</td>" +
			   "<td class=\"ra\">(.*?)</td>" +
			   "<td class=\"tbdy\">(.*?)</td>" +
			   "<td class=\"ra\">(.*?)</td>" +
			   "<td class=\"tbdy\">(.*?)</td>" +
			   "<td class=\"tbdy1\"><a href=\"(.*?)</a></td></tr>");

	   Pattern p3 = Pattern.compile("<tr class=\"(.*?)\"><td class=\"tbdy\">(.*?)</td><td class=\"tbdy\">(.*?)</td>.*<td class=\"tbdy1\">(.*?)</td>");

		//String regx1="<b style=\"font-size: 1.4em; text-align:center;color:#.*;\">(.*?)</b>(.*?)<b style=\"font-size: 1.1em; color:#.*;\">(.*?)</b>(.*?)开盘:</td> <td style=\"(.*?)\">(.*?)</td>(.*?)<td style=\"  color:#.*;width:91px;\">(.*?)</td>(.*?)<td style=\"  color:(.*?);width:91px;\">(.*?)</td>";

		String content = getPageContent("http://www.nfl.com/players/search?category=position&filter=defensiveback&conferenceAbbr=null&playerType=current&conference=ALL");

//	   System.out.println(content);

//		Pattern p= Pattern.compile(regx1);
//		String text=content.toString();

		List list = match(content,"tr","class");
		System.out.println(list);

	}// end of main method

}// end of class
