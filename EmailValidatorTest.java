package com.emailvalidator;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.main.RegistrationUser;

import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EmailValidatorTest {

	private String emailid;
	private Boolean expectedResult;
	private RegistrationUser ur;
	private static final String emailPattern = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*"
			+ "@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})$";

	public EmailValidatorTest(String emailid, Boolean expectedResult) {
		this.emailid = emailid;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testValidator() {
		return Arrays.asList(new Object[][] { { "raj.sahni@bl.co.in", true }, { "abc-ggsh@gmail.com", false },
				{ "abc@yahoo.com", false }, { "abc@gmail.com.com", true }, { "abc-100@abc.net", false } });
	}

	@Test
	public void WheneEmailPassed_Return_True_or_False() {
		System.out.println(
				"test result is :" + ur.regex(emailid, emailPattern) + " and expected result is " + expectedResult);
		assertEquals(expectedResult, ur.regex(emailid, emailPattern));
	}

	
	
	
	
	
	
}
