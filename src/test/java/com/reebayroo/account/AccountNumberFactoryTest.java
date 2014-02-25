package com.reebayroo.account;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.reebayroo.parsing.FaxCharConstants;
import com.reebayroo.parsing.TranslatedFaxChar;

public class AccountNumberFactoryTest {

	private AccountNumberFactory factory;
	private List<TranslatedFaxChar> validParsedFaxChars;
	private AccountCheckSumChecker checkSumChecker;
	private AccountInvalidNumberChecker invalidNumberChecker;
	private List<TranslatedFaxChar> invalidParsedFaxChars;

	@Before
	public void setup() {
		checkSumChecker = Mockito.mock(AccountCheckSumChecker.class);
		invalidNumberChecker = Mockito.mock(AccountInvalidNumberChecker.class);

		this.factory = new AccountNumberFactory(checkSumChecker, invalidNumberChecker);
		this.validParsedFaxChars = Arrays.asList(new TranslatedFaxChar(FaxCharConstants.THREE, 3));
		this.invalidParsedFaxChars = Arrays.asList(new TranslatedFaxChar(FaxCharConstants.THREE, 3));

	}

	@Test
	public void createValidAccount() {
		Mockito.when(checkSumChecker.eval(Mockito.anyListOf(TranslatedFaxChar.class))).thenReturn(true);
		Mockito.when(invalidNumberChecker.eval(Mockito.anyListOf(TranslatedFaxChar.class))).thenReturn(true);

		AccountNumber actual = factory.createAccountNumber(validParsedFaxChars);
		AccountNumber expected = new AccountNumber(validParsedFaxChars, AccountNumberStatus.OK);
		
		Mockito.verify(checkSumChecker, Mockito.times(1)).eval(Mockito.anyListOf(TranslatedFaxChar.class));
		Mockito.verify(invalidNumberChecker, Mockito.times(1)).eval(Mockito.anyListOf(TranslatedFaxChar.class));

		assertEquals(expected, actual);
	}
	@Test
	public void createIllAccount() {
		Mockito.when(invalidNumberChecker.eval(Mockito.anyListOf(TranslatedFaxChar.class))).thenReturn(false);

		AccountNumber actual = factory.createAccountNumber(invalidParsedFaxChars);
		AccountNumber expected = new AccountNumber(invalidParsedFaxChars, AccountNumberStatus.ILL);
		
		Mockito.verify(checkSumChecker, Mockito.times(0)).eval(Mockito.anyListOf(TranslatedFaxChar.class));
		Mockito.verify(invalidNumberChecker, Mockito.times(1)).eval(Mockito.anyListOf(TranslatedFaxChar.class));

		assertEquals(expected, actual);
	}
	@Test
	public void createErrAccount() {
		Mockito.when(checkSumChecker.eval(Mockito.anyListOf(TranslatedFaxChar.class))).thenReturn(false);
		Mockito.when(invalidNumberChecker.eval(Mockito.anyListOf(TranslatedFaxChar.class))).thenReturn(true);

		AccountNumber actual = factory.createAccountNumber(invalidParsedFaxChars);
		AccountNumber expected = new AccountNumber(invalidParsedFaxChars, AccountNumberStatus.ERR);
		
		Mockito.verify(checkSumChecker, Mockito.times(1)).eval(Mockito.anyListOf(TranslatedFaxChar.class));
		Mockito.verify(invalidNumberChecker, Mockito.times(1)).eval(Mockito.anyListOf(TranslatedFaxChar.class));

		assertEquals(expected, actual);
	}
}
