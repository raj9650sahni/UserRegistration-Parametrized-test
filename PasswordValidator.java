package com.passwordvalidator;

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
public class PasswordValidator {

	private String password;
	private Boolean expectedResult;
	private RegistrationUser ur;
	private static final String passwordPattern = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$";

	public PasswordValidator(String password, Boolean expectedResult) {
		this.password = password;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testValidator() {
		return Arrays.asList(new Object[][] { { "Raj.sahni@85120", true }, { "Shivammishra@97672", true },
				{ "78283@sgubah", false }, { "abc-100@abc.net", false }, { "asumit.ahuja@gmail.com", false } });
	}

	@Test
	public void WhenePasswordPassed_Return_True_or_False() {
		System.out.println(
				"test result is :" + ur.regex(password, passwordPattern) + " and expected result is " + expectedResult);
		assertEquals(expectedResult, ur.regex(password, passwordPattern));
	}

}
