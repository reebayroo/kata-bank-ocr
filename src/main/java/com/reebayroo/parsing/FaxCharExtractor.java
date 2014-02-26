package com.reebayroo.parsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class FaxCharExtractor {

	private static final int LINE_LENGHT = 27;
	private static final int MAX_CHARS_PER_LINE = 9;
	private static final int CHARS_IN_A_NUMBER = 3;

	public List<FaxChar> parse(FaxLine faxCharLine) {
		validateLength(faxCharLine.getFirstLine());
		validateLength(faxCharLine.getSecondLine());
		validateLength(faxCharLine.getThirdLine());

		List<FaxChar> parsedChars = new ArrayList<FaxChar>();
		for (int i = 0; i < MAX_CHARS_PER_LINE; i++) {
			FaxChar faxChar = new FaxChar(extractChars(faxCharLine.getFirstLine(), i), //
			        extractChars(faxCharLine.getSecondLine(), i), //
			        extractChars(faxCharLine.getThirdLine(), i) //
			);
			parsedChars.add(faxChar);
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
