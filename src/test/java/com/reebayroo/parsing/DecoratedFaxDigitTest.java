package com.reebayroo.parsing;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecoratedFaxDigitTest {

	@Test
	public void testEqualsObject() {
		assertEquals(new DecoratedFaxDigit(FaxDigitConstants.ZERO, 0), //
		        new DecoratedFaxDigit(FaxDigitConstants.ZERO, 0));
	}

	@Test
	public void testEqualsHashCode() {
		assertEquals(new DecoratedFaxDigit(FaxDigitConstants.ZERO, 0).hashCode(), //
		        new DecoratedFaxDigit(FaxDigitConstants.ZERO, 0).hashCode());
	}

}
