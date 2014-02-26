package com.reebayroo.parsing;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

public class FaxDigitDictionary {

	private static FaxDigitDictionary instance = null;
	private Map<FaxDigit, Integer> faxIndex = new HashMap<FaxDigit, Integer>();
	private Map<Integer, FaxDigit> valueIndex = new HashMap<Integer, FaxDigit>();

	private FaxDigitDictionary() {
		faxIndex.put(FaxDigitConstants.ZERO, Integer.valueOf(0));
		faxIndex.put(FaxDigitConstants.ONE, Integer.valueOf(1));
		faxIndex.put(FaxDigitConstants.TWO, Integer.valueOf(2));
		faxIndex.put(FaxDigitConstants.THREE, Integer.valueOf(3));
		faxIndex.put(FaxDigitConstants.FOUR, Integer.valueOf(4));
		faxIndex.put(FaxDigitConstants.FIVE, Integer.valueOf(5));
		faxIndex.put(FaxDigitConstants.SIX, Integer.valueOf(6));
		faxIndex.put(FaxDigitConstants.SEVEN, Integer.valueOf(7));
		faxIndex.put(FaxDigitConstants.EIGHT, Integer.valueOf(8));
		faxIndex.put(FaxDigitConstants.NINE, Integer.valueOf(9));

		valueIndex.put(Integer.valueOf(0), FaxDigitConstants.ZERO);
		valueIndex.put(Integer.valueOf(1), FaxDigitConstants.ONE);
		valueIndex.put(Integer.valueOf(2), FaxDigitConstants.TWO);
		valueIndex.put(Integer.valueOf(3), FaxDigitConstants.THREE);
		valueIndex.put(Integer.valueOf(4), FaxDigitConstants.FOUR);
		valueIndex.put(Integer.valueOf(5), FaxDigitConstants.FIVE);
		valueIndex.put(Integer.valueOf(6), FaxDigitConstants.SIX);
		valueIndex.put(Integer.valueOf(7), FaxDigitConstants.SEVEN);
		valueIndex.put(Integer.valueOf(8), FaxDigitConstants.EIGHT);
		valueIndex.put(Integer.valueOf(9), FaxDigitConstants.NINE);
	}

	public static FaxDigitDictionary getInstance() {
		if (instance == null) {
			instance = new FaxDigitDictionary();
		}
		return instance;
	}

	public boolean contains(FaxDigit faxDigit) {
		return faxIndex.containsKey(faxDigit);
	}

	public Integer get(FaxDigit faxDigit) {
		Validate.isTrue(contains(faxDigit), "invalid");
		return faxIndex.get(faxDigit);
	}

	public FaxDigit getByValue(int value) {
		return valueIndex.get(value);
	}

}
