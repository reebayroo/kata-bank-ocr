package com.reebayroo.parsing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FaxCharTranslatorTest {

	private FaxCharTranslator translator;
	public static final FaxChar INVALID = new FaxChar( //
	        " _ ",//
	        "|_|",//
	        "| |");

	@Before
	public void setup() {
		this.translator = new FaxCharTranslator();
	}

	@Test
	public void testTranslateValid() {
		List<TranslatedFaxChar> expected = Arrays.asList(new TranslatedFaxChar(FaxCharConstants.ZERO, 0));
		List<TranslatedFaxChar> actual = this.translator.translate(Arrays.asList(FaxCharConstants.ZERO));
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateInvlalid() {
		List<TranslatedFaxChar> expected = Arrays.asList(new TranslatedFaxChar(INVALID, -1));
		List<TranslatedFaxChar> actual = this.translator.translate(Arrays.asList(INVALID));
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void expectNotEmpty() {
		List<FaxChar> empty = Arrays.asList();
		this.translator.translate(empty);
	}

}
