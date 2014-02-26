package com.reebayroo.account;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.reebayroo.parsing.FaxDigitConstants;
import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountNumberFactoryTest {

	private AccountNumberFactory factory;
	private List<DecoratedFaxDigit> validParsedFaxChars;
	private AccountCheckSumChecker checkSumChecker;
	private AccountInvalidNumberChecker invalidNumberChecker;
	private List<DecoratedFaxDigit> invalidParsedFaxChars;
	private AccountNumberRestorer restorer;

	@Before
	public void setup() {
		checkSumChecker = Mockito.mock(AccountCheckSumChecker.class);
		invalidNumberChecker = Mockito.mock(AccountInvalidNumberChecker.class);
		restorer = Mockito.mock(AccountNumberRestorer.class);

		this.factory = new AccountNumberFactory(checkSumChecker, invalidNumberChecker, restorer);
		this.validParsedFaxChars = Arrays.asList(new DecoratedFaxDigit(FaxDigitConstants.THREE, 3));
		this.invalidParsedFaxChars = Arrays.asList(new DecoratedFaxDigit(FaxDigitConstants.THREE, 3));

	}

	@Test
	public void createValidAccount() {
		Mockito.when(checkSumChecker.eval(Mockito.anyListOf(DecoratedFaxDigit.class))).thenReturn(true);
		Mockito.when(invalidNumberChecker.eval(Mockito.anyListOf(DecoratedFaxDigit.class))).thenReturn(true);

		AccountNumber actual = factory.createAccountNumber(validParsedFaxChars);
		AccountNumber expected = new AccountNumber(validParsedFaxChars, AccountNumberStatus.OK);
		
		Mockito.verify(checkSumChecker, Mockito.times(1)).eval(Mockito.anyListOf(DecoratedFaxDigit.class));
		Mockito.verify(invalidNumberChecker, Mockito.times(1)).eval(Mockito.anyListOf(DecoratedFaxDigit.class));

		assertEquals(expected, actual);
	}
	@Test
	public void createIllAccount() {
		Mockito.when(invalidNumberChecker.eval(Mockito.anyListOf(DecoratedFaxDigit.class))).thenReturn(false);
		Mockito.when(restorer.restore(Mockito.isA(AccountNumber.class))).thenAnswer(new Answer<AccountNumber>(){
			public AccountNumber answer(InvocationOnMock invocation) throws Throwable {
	            return (AccountNumber) invocation.getArguments()[0];
            }
 		});
		
		AccountNumber actual = factory.createAccountNumber(invalidParsedFaxChars);
		AccountNumber expected = new AccountNumber(invalidParsedFaxChars, AccountNumberStatus.ILL);
		
		Mockito.verify(checkSumChecker, Mockito.times(0)).eval(Mockito.anyListOf(DecoratedFaxDigit.class));
		Mockito.verify(invalidNumberChecker, Mockito.times(1)).eval(Mockito.anyListOf(DecoratedFaxDigit.class));

		assertEquals(expected, actual);
	}
	@Test
	public void createErrAccount() {
		Mockito.when(checkSumChecker.eval(Mockito.anyListOf(DecoratedFaxDigit.class))).thenReturn(false);
		Mockito.when(invalidNumberChecker.eval(Mockito.anyListOf(DecoratedFaxDigit.class))).thenReturn(true);
		Mockito.when(restorer.restore(Mockito.isA(AccountNumber.class))).thenAnswer(new Answer<AccountNumber>(){
			public AccountNumber answer(InvocationOnMock invocation) throws Throwable {
	            return (AccountNumber) invocation.getArguments()[0];
            }
 		});

		AccountNumber actual = factory.createAccountNumber(invalidParsedFaxChars);
		AccountNumber expected = new AccountNumber(invalidParsedFaxChars, AccountNumberStatus.ERR);
		
		Mockito.verify(checkSumChecker, Mockito.times(1)).eval(Mockito.anyListOf(DecoratedFaxDigit.class));
		Mockito.verify(invalidNumberChecker, Mockito.times(1)).eval(Mockito.anyListOf(DecoratedFaxDigit.class));

		assertEquals(expected, actual);
	}
}
