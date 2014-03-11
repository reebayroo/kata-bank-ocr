package com.reebayroo.extra;

import java.util.LinkedList;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.Validate;

public class RomanNumeralsConverter {

	@SuppressWarnings("serial")
	public String convert(int naturalNumber) {
		Validate.isTrue(naturalNumber > 0, "Zero not supported.");
		Validate.isTrue(naturalNumber < 4000, "Four K not supported.");

		return //
		convertDigitsWithQueue(new StringBuilder(), naturalNumber, new LinkedList<NumeralCombination>() {
			{
				add(new NumeralCombination("X", "V", "I"));
				add(new NumeralCombination("C", "L", "X"));
				add(new NumeralCombination("M", "D", "C"));
				add(new NumeralCombination("", "", "M"));
			}

		}).reverse().toString();
	}

	private StringBuilder convertDigitsWithQueue(StringBuilder builder, int romanNumber, LinkedList<NumeralCombination> queue) {
		if (CollectionUtils.isNotEmpty(queue)) {
			convertDigits(builder, romanNumber % 10, queue.pop());
			convertDigitsWithQueue(builder, romanNumber / 10, queue);
		}
		return builder;
	}

	private void convertDigits(StringBuilder builder, int number, NumeralCombination numeralCombination) {
		if (number == 9) {
			builder.append(numeralCombination.getTenth());
			builder.append(numeralCombination.getUnit());
		} else if (number == 4) {
			builder.append(numeralCombination.getHalf());
			builder.append(numeralCombination.getUnit());
		} else if (number >= 5) {
			convertDigits(builder, number % 5, numeralCombination);
			builder.append(numeralCombination.getHalf());
		} else if (number > 0){
			convertDigits(builder, number - 1, numeralCombination);
			builder.append(numeralCombination.getUnit());
		}
	}

}

class NumeralCombination {
	private final String tenth;
	private final String half;
	private final String unit;

	public NumeralCombination(String tenth, String half, String unit) {
		this.tenth = tenth;
		this.half = half;
		this.unit = unit;
	}

	public String getTenth() {
		return tenth;
	}

	public String getHalf() {
		return half;
	}

	public String getUnit() {
		return unit;
	}

}