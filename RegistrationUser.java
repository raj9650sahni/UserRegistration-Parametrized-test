package com.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationUser {

	public static boolean regex(String exp, String regexName) {

		Pattern p = Pattern.compile(regexName);
		Matcher m = p.matcher(exp);
		boolean b = m.matches();
		if (b == true) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean regexN(String exp, String exp2, String regexfirst, String regexlast) {

		Pattern p = Pattern.compile(regexfirst);
		Matcher m = p.matcher(exp);
		boolean b = m.matches();

		Pattern q = Pattern.compile(regexlast);
		Matcher r = q.matcher(exp2);
		boolean c = r.matches();

		if (b == true && c == true) {
			return true;
		} else if (b == true && c == false) {
			return false;

		} else if (b == false && c == true) {
			return false;
		} else {
			return false;
		}

	}

}
