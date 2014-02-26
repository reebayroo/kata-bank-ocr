package com.reebayroo.parsing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FaxDigitDecoratorTest {

	private FaxDigitDecorator translator;
	public static final FaxDigit INVALID = new FaxDigit( //
	        " _ ",//
	        "|_|",//
	        "| |");

	@Before
	public void setup() {
		this.translator = new FaxDigitDecorator();
	}

	@Test
	public void testTranslateValid() {
		List<DecoratedFaxDigit> expected = Arrays.asList(new DecoratedFaxDigit(FaxDigitConstants.ZERO, 0));
		List<DecoratedFaxDigit> actual = this.translator.translate(Arrays.asList(FaxDigitConstants.ZERO));
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateInvlalid() {
		List<DecoratedFaxDigit> expected = Arrays.asList(new DecoratedFaxDigit(INVALID, -1));
		List<DecoratedFaxDigit> actual = this.translator.translate(Arrays.asList(INVALID));
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void expectNotEmpty() {
		this.translator.translate(new ArrayList<FaxDigit>());
	}

}
