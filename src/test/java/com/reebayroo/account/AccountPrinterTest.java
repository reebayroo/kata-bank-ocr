package com.reebayroo.account;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class AccountPrinterTest {

	private PrintStream out;
	private AccountPrinter accountPrinter;

	@Before
	public void setup() {

		out = Mockito.mock(PrintStream.class);
		this.accountPrinter = new AccountPrinter(out);
	}

	@Test
	public void testPrintValid() {
		int[] numbers = { 3, 4, 5, 8, 8, 2, 8, 6, 5 };
		AccountNumber accountNumber = new AccountNumber(TestHelper.createDigits(numbers), AccountNumberStatus.OK);
		accountPrinter.print(accountNumber);
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		Mockito.verify(out).print(argument.capture());
		assertEquals("345882865 OK", argument.getValue());
	}
	@Test
	public void testPrintErr() {
		int[] numbers = { 3, 4, 0, 8, 8, 2, 8, 6, 5 };
		AccountNumber accountNumber = new AccountNumber(TestHelper.createDigits(numbers), AccountNumberStatus.ERR);
		accountPrinter.print(accountNumber);
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		Mockito.verify(out).print(argument.capture());
		assertEquals("340882865 ERR", argument.getValue());
	}
	
	@Test
	public void testPrintAmbivalent() {
        AccountNumber original = TestHelper.createErr(4,9,0,0,6,7,7,1,5);
        AccountNumber alt1 = TestHelper.createOK(4,9,0,0,6,7,1,1,5);
        AccountNumber alt2 = TestHelper.createOK(4,9,0,0,6,7,7,1,9);
        AccountNumber alt3 = TestHelper.createOK(4,9,0,8,6,7,7,1,5);
		accountPrinter.print(AccountNumber.createAmbAccount(original, Arrays.asList(alt1, alt2, alt3)));
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		Mockito.verify(out).print(argument.capture());
		assertEquals("490067715 AMB ['490067115', '490067719', '490867715']", argument.getValue());
	}
}
