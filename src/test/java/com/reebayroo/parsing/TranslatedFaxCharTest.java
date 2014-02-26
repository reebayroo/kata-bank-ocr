package com.reebayroo.parsing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TranslatedFaxCharTest {

	@Test
	public void testEqualsObject() {
		assertEquals(new TranslatedFaxChar(FaxCharConstants.ZERO,  0),
					 new TranslatedFaxChar(FaxCharConstants.ZERO,  0));
	}
	@Test
	public void testEqualsHashCode() {
		assertEquals(new TranslatedFaxChar(FaxCharConstants.ZERO,  0).hashCode(),
				new TranslatedFaxChar(FaxCharConstants.ZERO,  0).hashCode());
	}

}
