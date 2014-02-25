package com.reebayroo.account;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.reebayroo.parsing.TranslatedFaxChar;

public class AccountCheckSumChecker {

	public boolean eval(List<TranslatedFaxChar> parsedFaxChars) {
		if (CollectionUtils.isEmpty(parsedFaxChars) || //
		        CollectionUtils.size(parsedFaxChars) != 9) {
			return false;
		}
		// 3 4 5 8 8 2 8 6 5
		// d9 d8 d7 d6 d5 d4 d3 d2 d1
		// (1*d1+2*d2+3*d3+4*d4+5*d5+6*d6+7*d7 + 8*d8 +9*d9) mod 11 = 0

		int result = 0;
		for (int i = 0, j = 9; i < 9; i++) {
			result += parsedFaxChars.get(i).getValue() * j--;
		}
		return result % 11 == 0;
	}

}
