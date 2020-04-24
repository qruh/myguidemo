package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {
	
	public void findWordsA(String s) {
		String candidate = s;
		
		String regex = "\\ba\\w*\\b";
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(candidate);
		String val = null;
		
		System.out.println("INPUT: " + candidate);
		System.out.println("REGEX: " + regex + "\r\n");
		
		while(m.find()) {
			val = m.group();
			System.out.println("MATCH: " + val);
		}
		if(val == null) {
			System.out.println("NO MATCHES: ");
		}
	}
}
