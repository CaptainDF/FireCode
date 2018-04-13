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

import javax.swing.JFileChooser;

public class Scraper {
	
	private Matcher matcher;
	private Regex regex;
	private String url;
	private String display;
	
	// constructor
	public Scraper (String url) {		
		this.url = url;
	}

	// reads the data from a web page and searches for the string matches
	public int parseData()
	{
	    int count = 0;
        try {
            java.net.URL url = new java.net.URL(this.url);

            Scanner input = new Scanner(url.openStream());

            while (input.hasNext()) {

                String line = input.nextLine();
                if(line.matches("<td class=\"tbdy1\"><a href=.*")){
                    if(line.matches(".*next</a> </span>.*")){
                        String a= line.substring(line.indexOf("</a> <a href=")-1, line.indexOf("</a> <a href="));
                        try{
                            count = Integer.parseInt(a);
                        }catch(Exception e){

                        }
                    }
                }

            }

        }catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL");
        }

        catch (java.io.IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
        return count;
	}
	
	// shows the output (scraped data) in a text-area 
	public String display(String display){
		
		return null;
	}
	
	

} //end class
		
		
			

	

	
	

