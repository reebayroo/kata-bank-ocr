package com.reebayroo.parsing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FaxCharBookTest {

	@Test
	public void validateInstanceNotNull() {
		assertNotNull(FaxCharBook.getInstance());
	}

	@Test
	public void containsAllNumbers() {
		FaxCharBook faxCharBook = FaxCharBook.getInstance();
		assertTrue(faxCharBook.contains(FaxCharBook.ZERO));
		assertTrue(faxCharBook.contains(FaxCharBook.ONE));
		assertTrue(faxCharBook.contains(FaxCharBook.TWO));
		assertTrue(faxCharBook.contains(FaxCharBook.THREE));
		assertTrue(faxCharBook.contains(FaxCharBook.FOUR));
		assertTrue(faxCharBook.contains(FaxCharBook.FIVE));
		assertTrue(faxCharBook.contains(FaxCharBook.SIX));
		assertTrue(faxCharBook.contains(FaxCharBook.SEVEN));
		assertTrue(faxCharBook.contains(FaxCharBook.EIGHT));
		assertTrue(faxCharBook.contains(FaxCharBook.NIVE));
	}

	@Test
	public void getIntegerValues() throws Exception {
		FaxCharBook faxCharBook = FaxCharBook.getInstance();
		assertEquals(faxCharBook.get(FaxCharBook.ZERO), Integer.valueOf(0));
		assertEquals(faxCharBook.get(FaxCharBook.ONE), Integer.valueOf(1));
		assertEquals(faxCharBook.get(FaxCharBook.TWO), Integer.valueOf(2));
		assertEquals(faxCharBook.get(FaxCharBook.THREE), Integer.valueOf(3));
		assertEquals(faxCharBook.get(FaxCharBook.FOUR), Integer.valueOf(4));
		assertEquals(faxCharBook.get(FaxCharBook.FIVE), Integer.valueOf(5));
		assertEquals(faxCharBook.get(FaxCharBook.SIX), Integer.valueOf(6));
		assertEquals(faxCharBook.get(FaxCharBook.SEVEN), Integer.valueOf(7));
		assertEquals(faxCharBook.get(FaxCharBook.EIGHT), Integer.valueOf(8));
		assertEquals(faxCharBook.get(FaxCharBook.NIVE), Integer.valueOf(9));

	}
}
