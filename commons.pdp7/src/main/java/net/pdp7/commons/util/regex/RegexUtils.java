package net.pdp7.commons.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	protected RegexUtils() {}
	
	public static String[] groups(String regex, String string) {
		Matcher matcher = Pattern.compile(regex).matcher(string);
		if(!matcher.matches()) {
			return new String[0];
		}
		
		String[] result = new String[matcher.groupCount()];
		
		for(int i=0; i<result.length; i++) {
			result[i] = matcher.group(i+1);
		}
		
		return result;
	}

}
