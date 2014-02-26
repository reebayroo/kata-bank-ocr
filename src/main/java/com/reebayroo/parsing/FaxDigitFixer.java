package com.reebayroo.parsing;

import java.util.ArrayList;
import java.util.List;

public class FaxDigitFixer {

	public List<DecoratedFaxDigit> findOptions(DecoratedFaxDigit decoratedFaxDigit) {

		List<DecoratedFaxDigit> result = new ArrayList<DecoratedFaxDigit>();
		FaxDigit faxDigit = decoratedFaxDigit.getOriginalDigit();
		char[][] rows = getRows(faxDigit.getLines());
		for (char[] row : rows) {
			for (int i = 0; i < 3; i++) {
				char original = switchChar(row, i);
				validateAndAdd(result, rows);
				row[i] = original;
			}
		}
		return result;
	}

	private void validateAndAdd(List<DecoratedFaxDigit> result, char[][] rows) {

		FaxDigit faxDigit = new FaxDigit(String.copyValueOf(rows[0]), String.copyValueOf(rows[1]), String.copyValueOf(rows[2]));

		if (FaxDigitDictionary.getInstance().contains(faxDigit)) {
			result.add(new DecoratedFaxDigit(faxDigit, //
			        FaxDigitDictionary.getInstance().get(faxDigit)));
		}

	}

	private char switchChar(char[] row, int index) {
		char current = row[index];
		switch (current) {
		case ' ':
			row[index] = index == 1 ? '_' : '|';
			break;
		default:
			row[index] = ' ';
			break;
		}
		return current;
	}

	private char[][] getRows(List<String> lines) {
	   	char[][] result = new char[][]{
	   				lines.get(0).toCharArray(),
	   				lines.get(1).toCharArray(),
	   				lines.get(2).toCharArray() };
	    return result;
    }
}
