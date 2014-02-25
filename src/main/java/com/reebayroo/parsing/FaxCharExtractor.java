package com.reebayroo.parsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class FaxCharExtractor {

	private static final int LINE_LENGHT = 27;
	private static final int MAX_CHARS_PER_LINE = 9;
	private static final int CHARS_IN_A_NUMBER = 3;

	public List<FaxChar> parse(String firstLine, String secondLine, String thirdLine) {

		Validate.isTrue(firstLine.length() == LINE_LENGHT, "Invalid first character line. Expecting a line %s with valid number of characters, got %s ", firstLine,
		        firstLine.length());
		Validate.isTrue(secondLine.length() == LINE_LENGHT, "Invalid second character line. Expecting a line %s with valid number of characters, got %s", secondLine,
		        secondLine.length());
		Validate.isTrue(thirdLine.length() == LINE_LENGHT, "Invalid third character line. Expecting a line %s with valid number of characters, got %s ", thirdLine,
		        thirdLine.length());

		List<FaxChar> parsedChars = new ArrayList<FaxChar>();
		for (int i = 0; i < MAX_CHARS_PER_LINE; i++) {
			FaxChar faxChar = new FaxChar(extractChars(firstLine, i), //
			        extractChars(secondLine, i), //
			        extractChars(thirdLine, i) //
			);
			parsedChars.add(faxChar);
		}
		return parsedChars;

	}

	private String extractChars(String line, int i) {
		return line.substring(i * CHARS_IN_A_NUMBER, (i + 1) * CHARS_IN_A_NUMBER);
	}

}
