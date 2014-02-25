package com.reebayroo;

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
		assertTrue(checker.eval(new int[] { 3, 4, 5, 8, 8, 2, 8, 6, 5 }));
	}

	@Test
	public void testInvalidCase() {
		assertFalse(checker.eval(new int[] { 9, 4, 5, 8, 8, 2, 8, 3, 5 }));
	}

	@Test
	public void nullReturnsFalse() {
		assertFalse(checker.eval(null));
	}

	@Test
	public void irregularArrayReturnsFalse() {
		assertFalse(checker.eval(new int[] { 0, 3 }));
	}
}
