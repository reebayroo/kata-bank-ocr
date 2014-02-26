package com.reebayroo.account;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;

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
		AccountNumber accountNumber = new AccountNumber(TestHelper.create(numbers), AccountNumberStatus.OK);
		accountPrinter.print(accountNumber);
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		Mockito.verify(out).print(argument.capture());
		assertEquals("345882865 OK", argument.getValue());
	}
	@Test
	public void testPrintInvalid() {
		int[] numbers = { 3, 4, -1, 8, 8, 2, 8, 6, 5 };
		AccountNumber accountNumber = new AccountNumber(TestHelper.create(numbers), AccountNumberStatus.ILL);
		accountPrinter.print(accountNumber);
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		Mockito.verify(out).print(argument.capture());
		assertEquals("34?882865 ILL", argument.getValue());
	}

}
