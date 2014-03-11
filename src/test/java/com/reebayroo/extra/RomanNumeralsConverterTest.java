package com.reebayroo.extra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralsConverterTest {

	private RomanNumeralsConverter converter;

	@Before
	public void setup() {
		this.converter = new RomanNumeralsConverter();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBiggerThanZero() {
		converter.convert(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSmallerThan4000() {
		converter.convert(4000);
	}

	@Test
	public void assertThat1IsI() {
		assertEquals("I", converter.convert(1));
	}

	@Test
	public void assertThat2IsII() {
		assertEquals("II", converter.convert(2));
	}

	@Test
	public void assertThat3IsIII() {
		assertEquals("III", converter.convert(3));
	}

	@Test
	public void assertThat4IsIV() {
		assertEquals("IV", converter.convert(4));
	}

	@Test
	public void assertThat5IsV() {
		assertEquals("V", converter.convert(5));
	}

	@Test
	public void assertThat6IsVI() {
		assertEquals("VI", converter.convert(6));
	}

	@Test
	public void assertThat7IsVII() {
		assertEquals("VII", converter.convert(7));
	}

	@Test
	public void assertThat8IsVIII() {
		assertEquals("VIII", converter.convert(8));
	}

	@Test
	public void assertThat9IsIX() {
		assertEquals("IX", converter.convert(9));
	}

	@Test
	public void assertThat10IsX() {
		assertEquals("X", converter.convert(10));
	}

	@Test
	public void assertThat11IsXI() {
		assertEquals("XI", converter.convert(11));
	}

	@Test
	public void assertThat12IsXII() {
		assertEquals("XII", converter.convert(12));
	}

	@Test
	public void assertThat502IsDII() {
		assertEquals("DII", converter.convert(502));
	}

	@Test
	public void assertThat207IsCCVII() {
		assertEquals("CCVII", converter.convert(207));
	}

	@Test
	public void assertThat309IsCCCIX() {
		assertEquals("CCCIX", converter.convert(309));
	}

	@Test
	public void assertThat819IsDCCCXIX() {
		assertEquals("DCCCXIX", converter.convert(819));
	}

	@Test
	public void assertThat1000IsM() {
		assertEquals("M", converter.convert(1000));
	}

	@Test
	public void assertThat3534IsMMMDXXXIV() {
		assertEquals("MMMDXXXIV", converter.convert(3534));
	}

	@Test
	public void assertThat3000IsMMM() {
		assertEquals("MMM", converter.convert(3000));
	}

	@Test
	public void assertThat3999IsMMMCMXCIX() {
		assertEquals("MMMCMXCIX", converter.convert(3999));
	}
}
