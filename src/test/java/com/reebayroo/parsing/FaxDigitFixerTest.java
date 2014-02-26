package com.reebayroo.parsing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.reebayroo.account.TestHelper;
import com.reebayroo.parsing.FaxDigitFixer;

public class FaxDigitFixerTest {

	private FaxDigitFixer fixer;
	public static final FaxDigit INVALID_A = new FaxDigit( //
	        " _ ",//
	        "|_|",//
	        "| |");
	public static final FaxDigit INVALID_1 = new FaxDigit( //
			"   ",//
			"   ",//
			"  |");
	@Before
	public void setup() {
		this.fixer = new FaxDigitFixer();
	}

	@Test
	public void testForSeven() {
		List<DecoratedFaxDigit> options = fixer.findOptions(TestHelper.create(7).get(0));
		assertEquals(options, TestHelper.create(1));
		
	}
	@Test
	public void testForOne() {
		List<DecoratedFaxDigit> options = fixer.findOptions(TestHelper.create(1).get(0));
		assertEquals(options, TestHelper.create(7));
		
	}
	@Test
	public void testForSix() {
		List<DecoratedFaxDigit> options = fixer.findOptions(TestHelper.create(6).get(0));
		assertEquals(options, TestHelper.create(8, 5));
	}
	@Test
	public void testForIinvalid1() {
		DecoratedFaxDigit invalid = new DecoratedFaxDigit(INVALID_1, -1);
		List<DecoratedFaxDigit> options = fixer.findOptions(invalid );
		assertEquals(options, TestHelper.create(1));
	}
	@Test
	public void testForIinvalidA() {
		DecoratedFaxDigit invalid = new DecoratedFaxDigit(INVALID_A, -1);
		List<DecoratedFaxDigit> options = fixer.findOptions(invalid );
		assertEquals(options, TestHelper.create(8));
	}
}
