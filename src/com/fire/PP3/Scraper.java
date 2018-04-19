package com.fire.PP3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

import javax.swing.JFileChooser;

public class Scraper {
	
	private Matcher matcher;
	private Regex regex;
	private String url;
	private String display;
	
	// constructor
	public Scraper (String url, Regex regex) {
		this.url = url;
		this.regex = regex;
	}

	// reads the data from a web page and searches for the string matches
	public int parseData()
	{
        BufferedWriter bw = null;
        Pattern pattern1 = Pattern.compile(".*</tbody>.*"); //end
        Pattern pattern2 = Pattern.compile("<td class=\"tbdy1\"><a href=\"/teams(.*?)</a></td></tr>"); //end of every player and signal for team
        Pattern pattern3 = Pattern.compile("^<td><a href=\"/player(.*?)</a></td>");//signal for player's name
        Pattern pattern4 = Pattern.compile("^<td class=\"tbdy\">[A-Z][A-Z]</td>");//signal for player's position
        Pattern pattern5 = Pattern.compile("^<td class=\"tbdy\">[\\d]*+</td>");	//signal for player's number
        Pattern pattern6 = Pattern.compile("<td class=\"tbdy\">[\\d.-]*+</td>");//signal for player's TCKL, SCK, INT

        String content = getPageContent("http://www.nfl.com/players/search?category=position&filter=defensiveback&conferenceAbbr=null&playerType=current&conference=ALL");

        return 0;
	}

    public static String getPageContent(String myurl){//在此导入网址链接
        StringBuffer sb = new StringBuffer();
        URL url =null;
        Scanner scanner = null;
        try {
            url = new URL(myurl);
            URLConnection conn = url.openConnection();

            scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNextLine()) {
                String content = scanner.nextLine();
                sb.append(content).append("\r\n");
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            scanner.close();
        }
        return sb.toString();
    }

    // shows the output (scraped data) in a text-area
	public String display(String display){
		
		return null;
	}
	
	

} //end class
		
		
			

	

	
	

