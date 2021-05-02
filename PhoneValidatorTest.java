package cpm.phoneValidator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.main.RegistrationUser;

@RunWith(Parameterized.class)
public class PhoneValidatorTest {
	
	private String phone;
	private boolean expectedResult;
	private static final String phonePattern ="^[1-9]{2}[ ][0-9]{10}$";
	private RegistrationUser ur;
	
	public PhoneValidatorTest(String phone ,boolean expectedResult) {
		this.phone =  phone;
		this.expectedResult = expectedResult;
		
	}
	
	
	@Parameterized.Parameters
	public static Collection<Object[]> tests() {
		
		return Arrays.asList(new Object[][] { { "91 8920047808", true }, { "9650138436", false },
			{ "+ 8527478469", false }, { " 9867886756231447", false }, { "8848988959", false } });
		
	}
	
	
	@Test
	public void WhenPassedPhone_Return_true_or_false() {
		System.out.println(" Phone test Expected is :" + expectedResult + " and originally is " + ur.regex(phone,phonePattern));
		assertEquals(expectedResult, ur.regex(phone, phonePattern));
	}
	
	

}
