package com.reebayroo.account;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AccountCheckSumCheckerTest {

	private AccountCheckSumChecker checker;

	@Before
	public void setup() {
		checker = new AccountCheckSumChecker();
	}

	@Test
	public void testValidCase() {
		int[] numbers = { 3, 4, 5, 8, 8, 2, 8, 6, 5 };
		assertTrue(checker.eval(TestHelper.createDigits(numbers)));
	}

	@Test
	public void testInvalidCase() {
		int[] numbers = { 9, 4, 5, 8, 8, 2, 8, 3, 5 };
		assertFalse(checker.eval(TestHelper.createDigits(numbers)));
	}

	@Test
	public void nullReturnsFalse() {
		assertFalse(checker.eval(null));
	}

	@Test
	public void irregularArrayReturnsFalse() {
		int[] numbers = { 0, 3 };
		assertFalse(checker.eval(TestHelper.createDigits(numbers)));
	}

	@Test
	public void testAdditionalNumbers() {
		assertTrue(checker.eval(TestHelper.createDigits(4, 9, 0, 0, 6, 7, 1, 1, 5)));
		assertTrue(checker.eval(TestHelper.createDigits(4, 9, 0, 0, 6, 7, 7, 1, 9)));
		assertTrue(checker.eval(TestHelper.createDigits(4, 9, 0, 8, 6, 7, 7, 1, 5)));
	}
}
