package com.reebayroo.parsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class FaxDigitExtractor {

	private static final int LINE_LENGHT = 27;
	private static final int MAX_CHARS_PER_LINE = 9;
	private static final int CHARS_IN_A_NUMBER = 3;

	public List<FaxDigit> parse(FaxLine faxCharLine) {
		validateLength(faxCharLine.getFirstLine());
		validateLength(faxCharLine.getSecondLine());
		validateLength(faxCharLine.getThirdLine());

		List<FaxDigit> parsedChars = new ArrayList<FaxDigit>();
		for (int i = 0; i < MAX_CHARS_PER_LINE; i++) {
			FaxDigit faxDigit = new FaxDigit(extractChars(faxCharLine.getFirstLine(), i), //
			        extractChars(faxCharLine.getSecondLine(), i), //
			        extractChars(faxCharLine.getThirdLine(), i) //
			);
			parsedChars.add(faxDigit);
		}
		return parsedChars;

	}

	private void validateLength(String line) {
		Validate.isTrue(line.length() == LINE_LENGHT, "Invalid character line. Expecting a line %s with valid number of characters, got %s ", line, line.length());
	}

	private String extractChars(String line, int i) {
		return line.substring(i * CHARS_IN_A_NUMBER, (i + 1) * CHARS_IN_A_NUMBER);
	}

}
