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
		assertTrue(faxCharBook.contains(FaxCharConstants.ZERO));
		assertTrue(faxCharBook.contains(FaxCharConstants.ONE));
		assertTrue(faxCharBook.contains(FaxCharConstants.TWO));
		assertTrue(faxCharBook.contains(FaxCharConstants.THREE));
		assertTrue(faxCharBook.contains(FaxCharConstants.FOUR));
		assertTrue(faxCharBook.contains(FaxCharConstants.FIVE));
		assertTrue(faxCharBook.contains(FaxCharConstants.SIX));
		assertTrue(faxCharBook.contains(FaxCharConstants.SEVEN));
		assertTrue(faxCharBook.contains(FaxCharConstants.EIGHT));
		assertTrue(faxCharBook.contains(FaxCharConstants.NINE));
	}

	@Test
	public void getIntegerValues() throws Exception {
		FaxCharBook faxCharBook = FaxCharBook.getInstance();
		assertEquals(faxCharBook.get(FaxCharConstants.ZERO), Integer.valueOf(0));
		assertEquals(faxCharBook.get(FaxCharConstants.ONE), Integer.valueOf(1));
		assertEquals(faxCharBook.get(FaxCharConstants.TWO), Integer.valueOf(2));
		assertEquals(faxCharBook.get(FaxCharConstants.THREE), Integer.valueOf(3));
		assertEquals(faxCharBook.get(FaxCharConstants.FOUR), Integer.valueOf(4));
		assertEquals(faxCharBook.get(FaxCharConstants.FIVE), Integer.valueOf(5));
		assertEquals(faxCharBook.get(FaxCharConstants.SIX), Integer.valueOf(6));
		assertEquals(faxCharBook.get(FaxCharConstants.SEVEN), Integer.valueOf(7));
		assertEquals(faxCharBook.get(FaxCharConstants.EIGHT), Integer.valueOf(8));
		assertEquals(faxCharBook.get(FaxCharConstants.NINE), Integer.valueOf(9));

	}

	@Test
	public void getByValue() throws Exception {
		FaxCharBook faxCharBook = FaxCharBook.getInstance();
		assertEquals(faxCharBook.getByValue(0), FaxCharConstants.ZERO);
		assertEquals(faxCharBook.getByValue(1), FaxCharConstants.ONE);
		assertEquals(faxCharBook.getByValue(2), FaxCharConstants.TWO);
		assertEquals(faxCharBook.getByValue(3), FaxCharConstants.THREE);
		assertEquals(faxCharBook.getByValue(4), FaxCharConstants.FOUR);
		assertEquals(faxCharBook.getByValue(5), FaxCharConstants.FIVE);
		assertEquals(faxCharBook.getByValue(6), FaxCharConstants.SIX);
		assertEquals(faxCharBook.getByValue(7), FaxCharConstants.SEVEN);
		assertEquals(faxCharBook.getByValue(8), FaxCharConstants.EIGHT);
		assertEquals(faxCharBook.getByValue(9), FaxCharConstants.NINE);

	}
}
