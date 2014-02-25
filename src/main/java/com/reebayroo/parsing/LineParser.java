package com.reebayroo.parsing;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class LineParser {

	public int[] parse(String string) {
		Validate.isTrue(string != null && StringUtils.countMatches(string, "\n") == 4, "Line is required");
		String[] lines = StringUtils.split(string, "\n");
		Validate.isTrue(lines.length == 3, "Fourth line shoud be blank");

		String firstLine = lines[0];
		String secondLine = lines[1];
		String thirdLine = lines[2];

		Validate.isTrue(firstLine.length() == 27, "Invalid first character line. Expecting a line %s with valid number of characters, got %s ", firstLine, firstLine.length());
		Validate.isTrue(secondLine.length() == 27, "Invalid second character line. Expecting a line %s with valid number of characters, got %s", secondLine, secondLine.length());
		Validate.isTrue(thirdLine.length() == 27, "Invalid third character line. Expecting a line %s with valid number of characters, got %s ", thirdLine, thirdLine.length());

		int[] result = new int[9];
		for (int i = 0; i < 9; i++) {
			FaxChar faxChar = new FaxChar(extractChars(firstLine, i), //
			        extractChars(secondLine, i), //
			        extractChars(thirdLine, i) //
			);
			FaxCharBook faxCharBook = FaxCharBook.getInstance();
			Validate.notNull(faxCharBook);
			
			result[i]= faxCharBook.contains(faxChar) ? faxCharBook.get(faxChar) : -1;
		}

		return result;

	}

	private String extractChars(String line, int i) {
	    return line.substring(i*3, (i+1) * 3);
    }

}
