package com.lastNameValidatorTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.main.RegistrationUser;

@RunWith(Parameterized.class)
public class NameValidatorTest {

	private String firstname;
	private String lastname;
	private boolean expectedResult;
	private static final String firstPattern = "^[A-Z]{1}[a-z]{2,}$";
	private static final String lastPattern = "^[A-Z][a-z]{3,19}$";
	private RegistrationUser ur;

	public NameValidatorTest(String firstname, String lastname, boolean expectedResult) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testcases() {
		return Arrays.asList(new Object[][] { { "Raj", "Sahni", true }, { "shivam", "mishra", false },
				{ " Amit", "Verma", false }, { "Anil ", "sharma", false }, { "Barry", "Allen", true } });

	}

	@Test
	public void whenNamesPassed_Return_True_or_False() {
		assertEquals(expectedResult, ur.regexN(firstname, lastname, firstPattern, lastPattern));
	}

}
