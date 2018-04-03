package com.fire.PP3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	public void parseData() 
	{
		
	}
	
	// shows the output (scraped data) in a text-area 
	public String display(String display){
		
		return null;
	}
	
	

} //end class
		
		
			

	

	
	

