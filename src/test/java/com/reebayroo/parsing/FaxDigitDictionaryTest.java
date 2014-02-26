package com.reebayroo.parsing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FaxDigitDictionaryTest {

	@Test
	public void validateInstanceNotNull() {
		assertNotNull(FaxDigitDictionary.getInstance());
	}

	@Test
	public void containsAllNumbers() {
		FaxDigitDictionary faxDigitDictionary = FaxDigitDictionary.getInstance();
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.ZERO));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.ONE));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.TWO));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.THREE));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.FOUR));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.FIVE));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.SIX));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.SEVEN));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.EIGHT));
		assertTrue(faxDigitDictionary.contains(FaxDigitConstants.NINE));
	}

	@Test
	public void getIntegerValues() throws Exception {
		FaxDigitDictionary faxDigitDictionary = FaxDigitDictionary.getInstance();
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.ZERO), Integer.valueOf(0));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.ONE), Integer.valueOf(1));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.TWO), Integer.valueOf(2));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.THREE), Integer.valueOf(3));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.FOUR), Integer.valueOf(4));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.FIVE), Integer.valueOf(5));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.SIX), Integer.valueOf(6));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.SEVEN), Integer.valueOf(7));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.EIGHT), Integer.valueOf(8));
		assertEquals(faxDigitDictionary.get(FaxDigitConstants.NINE), Integer.valueOf(9));

	}

	@Test
	public void getByValue() throws Exception {
		FaxDigitDictionary faxDigitDictionary = FaxDigitDictionary.getInstance();
		assertEquals(faxDigitDictionary.getByValue(0), FaxDigitConstants.ZERO);
		assertEquals(faxDigitDictionary.getByValue(1), FaxDigitConstants.ONE);
		assertEquals(faxDigitDictionary.getByValue(2), FaxDigitConstants.TWO);
		assertEquals(faxDigitDictionary.getByValue(3), FaxDigitConstants.THREE);
		assertEquals(faxDigitDictionary.getByValue(4), FaxDigitConstants.FOUR);
		assertEquals(faxDigitDictionary.getByValue(5), FaxDigitConstants.FIVE);
		assertEquals(faxDigitDictionary.getByValue(6), FaxDigitConstants.SIX);
		assertEquals(faxDigitDictionary.getByValue(7), FaxDigitConstants.SEVEN);
		assertEquals(faxDigitDictionary.getByValue(8), FaxDigitConstants.EIGHT);
		assertEquals(faxDigitDictionary.getByValue(9), FaxDigitConstants.NINE);

	}
}
