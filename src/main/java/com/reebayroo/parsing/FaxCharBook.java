package com.reebayroo.parsing;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

class FaxCharBook {

	private static FaxCharBook instance = null;
	private Map<FaxChar, Integer> faxIndex = new HashMap<FaxChar, Integer>();
	private Map<Integer, FaxChar> valueIndex = new HashMap<Integer, FaxChar>();

	private FaxCharBook() {
		faxIndex.put(FaxCharConstants.ZERO, Integer.valueOf(0));
		faxIndex.put(FaxCharConstants.ONE, Integer.valueOf(1));
		faxIndex.put(FaxCharConstants.TWO, Integer.valueOf(2));
		faxIndex.put(FaxCharConstants.THREE, Integer.valueOf(3));
		faxIndex.put(FaxCharConstants.FOUR, Integer.valueOf(4));
		faxIndex.put(FaxCharConstants.FIVE, Integer.valueOf(5));
		faxIndex.put(FaxCharConstants.SIX, Integer.valueOf(6));
		faxIndex.put(FaxCharConstants.SEVEN, Integer.valueOf(7));
		faxIndex.put(FaxCharConstants.EIGHT, Integer.valueOf(8));
		faxIndex.put(FaxCharConstants.NINE, Integer.valueOf(9));

		valueIndex.put(Integer.valueOf(0), FaxCharConstants.ZERO);
		valueIndex.put(Integer.valueOf(1), FaxCharConstants.ONE);
		valueIndex.put(Integer.valueOf(2), FaxCharConstants.TWO);
		valueIndex.put(Integer.valueOf(3), FaxCharConstants.THREE);
		valueIndex.put(Integer.valueOf(4), FaxCharConstants.FOUR);
		valueIndex.put(Integer.valueOf(5), FaxCharConstants.FIVE);
		valueIndex.put(Integer.valueOf(6), FaxCharConstants.SIX);
		valueIndex.put(Integer.valueOf(7), FaxCharConstants.SEVEN);
		valueIndex.put(Integer.valueOf(8), FaxCharConstants.EIGHT);
		valueIndex.put(Integer.valueOf(9), FaxCharConstants.NINE);
	}

	public static FaxCharBook getInstance() {
		if (instance == null) {
			instance = new FaxCharBook();
		}
		return instance;
	}

	public boolean contains(FaxChar faxChar) {
		return faxIndex.containsKey(faxChar);
	}

	public Integer get(FaxChar faxChar) {
		Validate.isTrue(contains(faxChar), "invalid");
		return faxIndex.get(faxChar);
	}

	public FaxChar getByValue(int value) {
		return valueIndex.get(value);
	}

}
