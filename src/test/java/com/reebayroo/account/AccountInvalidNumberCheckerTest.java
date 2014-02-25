package com.reebayroo.account;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AccountInvalidNumberCheckerTest {

	private AccountInvalidNumberChecker checker;

	@Before
	public void setup() {
		checker = new AccountInvalidNumberChecker();
	}

	@Test
	public void testValidCase() {
		int[] numbers = { 3, 4, 5, 8, 8, 2, 8, 6, 5 };
		assertTrue(checker.eval(CheckerTestHelper.create(numbers)));
	}

	@Test
	public void testInvalidCase() {
		int[] numbers = { 9, 4, 5, 8, 8, 2, 8, -1, 5 };
		assertFalse(checker.eval(CheckerTestHelper.create(numbers)));
	}

	@Test
	public void nullReturnsFalse() {
		assertFalse(checker.eval(null));
	}

 

}
