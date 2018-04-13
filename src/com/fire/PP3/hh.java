package com.fire.PP3;

 import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class hh {
	
	
	
	public static int Find(String UrlName){
		int count = 0;
		try {
			java.net.URL url = new java.net.URL(UrlName);
			
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
		
	catch (IOException ex) {
		System.out.println("I/O Errors: no such file");
		}
		return count;
	}
	
	
	public static void ReadAndWrite(String[] Url, String FileName){
		BufferedWriter bw = null;
		Pattern pattern1 = Pattern.compile(".*</tbody>.*"); //end
		Pattern pattern2 = Pattern.compile("<td class=\"tbdy1\"><a href=\"/teams(.*?)</a></td></tr>"); //end of every player and signal for team
		Pattern pattern3 = Pattern.compile("^<td><a href=\"/player(.*?)</a></td>");//signal for player's name
		Pattern pattern4 = Pattern.compile("^<td class=\"tbdy\">[A-Z][A-Z]</td>");//signal for player's position
		Pattern pattern5 = Pattern.compile("^<td class=\"tbdy\">[\\d]*+</td>");	//signal for player's number
		Pattern pattern6 = Pattern.compile("<td class=\"tbdy\">[\\d.-]*+</td>");//signal for player's TCKL, SCK, INT
		try {
			bw = new BufferedWriter(new FileWriter(FileName));
			bw.write(String.format("%-10s %-10s %-30s %-10s %-10s %-10s %-10s %-10s", "POS", "NUM", "NAME", "STATUS", "TCKL", "SCK", "INT", "TEAM"));
			bw.newLine();
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i< Find(Url[0]);i++){
			
		
		try {
			java.net.URL url = new java.net.URL(Url[i]);
			int count = 0;
			Scanner input = new Scanner(url.openStream());
			
			while (input.hasNext()) {
				
				String line = input.nextLine();
				if(line.matches("<tbody>")){
					while(!pattern1.matcher(line).find()){
						line = input.nextLine();
						String pos = null, num= null, name= null, status= null, tckl= null, sck= null, Int= null, team= null, result= null;
						if(line.matches("<tr class=\"odd\">")||line.matches("<tr class=\"even\">")){//Begin find player
							//System.out.println(line);
							while(!pattern2.matcher(line).find()){
								
								/*player's pos, num, name*/
								while(!line.matches("<td class=\"ra\">")){
									line = input.nextLine();
									//System.out.println(line);
									//Name
									if(pattern3.matcher(line).find()){
										name=line.substring(line.indexOf("\">")+2,line.indexOf("</a"));
										System.out.println("Name"+name);
										line = input.nextLine();
										status=line.substring(line.indexOf(">")+1,line.indexOf("</td"));
										System.out.println("Status"+status);
										}
									//Pos
									else if(pattern4.matcher(line).find()){
											pos=line.substring(line.indexOf(">")+1,line.indexOf("</"));
											System.out.println("Pos"+pos);
											}
									//Num
									else if(pattern5.matcher(line).find()){
											num=line.substring(line.indexOf(">")+1,line.indexOf("</"));
											System.out.println("Num"+num);
											}
								}
								
								/*player's TCKL, SCK, INT, Team*/
								while(!pattern2.matcher(line).find()){
									line=input.nextLine();
									
									//TCKL
									if(line.matches(".*TCKL.*")){
										while(!line.matches("<td class=\"ra\">")){
											
											if(pattern6.matcher(line).find()){
												tckl = line.substring(line.indexOf(">")+1,line.indexOf("</td"));
												//System.out.println("TCKL"+tckl);
											}
											line=input.nextLine();
											
										}
										
									}
									
									//SCK
									if(line.matches(".*SCK.*")){
										while(!line.matches("<td class=\"ra\">")){
											//System.out.println(line);
											if(pattern6.matcher(line).find()){
												//System.out.println(line);
												sck = line.substring(line.indexOf(">")+1,line.indexOf("</td"));
												System.out.println("SCK"+sck);
											}
											line=input.nextLine();
										}
										
									}
									
									//INT
									if(line.matches(".*INT.*")){
										while(!pattern2.matcher(line).find()){
											
											if(pattern6.matcher(line).find()){
												Int = line.substring(line.indexOf(">")+1,line.indexOf("</td"));
												System.out.println("INT"+Int);
											}
											line=input.nextLine();
										}
										
									}
									
									//Team
									if(pattern2.matcher(line).find()){
										
										String a;
										a = line.substring(line.indexOf("\">")+2,line.indexOf("</td"));
										team = a.substring(a.indexOf("\">")+2,a.indexOf("</a"));
										System.out.println(team);
									}
									
								}
								
							}
						}
						result=String.format("%-10s %-10s %-30s %-10s %-10s %-10s %-10s %-10s",pos, num, name, status, tckl, sck, Int, team);
						System.out.println(result);
						bw.write(result);
						bw.newLine();							
					}				
				}		
				}
	
			}catch (java.net.MalformedURLException ex) {
		System.out.println("Invalid URL");
		}
	catch (IOException ex) {
		System.out.println("I/O Errors: no such file");
		}
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		String[] url = new String[100];
		for (int i=0; i<Find("http://www.nfl.com/players/search?category=position&filter=defensiveback&conferenceAbbr=null&playerType=current&conference=ALL");i++)
		{
			int j=i+1;
			url[i] = "http://www.nfl.com/players/search?category=position&playerType=current&conference=ALL&d-447263-p="+j+"&filter=defensiveback&conferenceAbbr=null";
		
		}
		
		ReadAndWrite(url, "Output.txt");
		JOptionPane.showMessageDialog(null, "The program is complete", "CIS611 Assigenment7", JOptionPane.INFORMATION_MESSAGE);
	}
}
