package PP4;
 

import java.util.regex.Pattern;

public class Regex {
	
	
	
	//pattern attributes
	private Pattern pos;
	private Pattern num;
	private Pattern llayerName;
	private Pattern status;
	private Pattern tckl;
	private Pattern sck;
	private Pattern intt;
	private Pattern team;
	
	//constructor
	public Regex(Pattern pos, Pattern num, Pattern llayerName, Pattern status, Pattern tckl, Pattern sck, Pattern intt,
			Pattern team) {
		this.pos = pos;
		this.num = num;
		this.llayerName = llayerName;
		this.status = status;
		this.tckl = tckl;
		this.sck = sck;
		this.intt = intt;
		this.team = team;
	}
	
	// 	add getter and setter methods
	
}
