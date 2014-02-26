package com.reebayroo.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

		AccountNumberStatus status = AccountNumberStatus.ERR;
		AccountNumber accountNumber = createAccount(status, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		AccountNumber actual = restorer.restore(accountNumber);

		assertEquals(createAccount(AccountNumberStatus.OK, 7, 1, 1, 1, 1, 1, 1, 1, 1), actual);
	}

	private AccountNumber createAccount(AccountNumberStatus status, int... args) {
		List<DecoratedFaxDigit> parsedFaxChars = TestHelper.create(args);
		AccountNumber accountNumber = new AccountNumber(parsedFaxChars, status);
		return accountNumber;
	}

}
