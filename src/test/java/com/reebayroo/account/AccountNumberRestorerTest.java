package com.reebayroo.account;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountNumberRestorerTest {

	private AccountNumberRestorer restorer;

	@Before
	public void setup() {
		this.restorer = new AccountNumberRestorer();
	}

	@Test
	public void testSimpleFix() {

		AccountNumber accountNumber = createAccount(AccountNumberStatus.ERR, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		AccountNumber actual = restorer.restore(accountNumber);

		assertEquals(createAccount(AccountNumberStatus.OK, 7, 1, 1, 1, 1, 1, 1, 1, 1), actual);
	}

	@Test
	public void testAmbivalentSuggestion() {
		AccountNumber original = createAccount(AccountNumberStatus.ERR, 4, 9, 0, 0, 6, 7, 7, 1, 5);

		AccountNumber altOne = createAccount(AccountNumberStatus.OK, 4, 9, 0, 8, 6, 7, 7, 1, 5);
		AccountNumber altThree = createAccount(AccountNumberStatus.OK, 4, 9, 0, 0, 6, 7, 7, 1, 9);
		AccountNumber altTwo = createAccount(AccountNumberStatus.OK, 4, 9, 0, 0, 6, 7, 1, 1, 5);
		AccountNumber expected = AccountNumber.createAmbAccount(original, Arrays.asList(altOne, altTwo, altThree));

		AccountNumber actual = restorer.restore(original);
		assertEquals(actual, expected);
	}

	private AccountNumber createAccount(AccountNumberStatus status, int... args) {
		List<DecoratedFaxDigit> parsedFaxChars = TestHelper.createDigits(args);
		AccountNumber accountNumber = new AccountNumber(parsedFaxChars, status);
		return accountNumber;
	}

}
