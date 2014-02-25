package com.reebayroo.account;

import java.util.ArrayList;
import java.util.List;

import com.reebayroo.parsing.FaxCharConstants;
import com.reebayroo.parsing.TranslatedFaxChar;

public class CheckerTestHelper {

	public static List<TranslatedFaxChar> create(int... numbers) {
		List<TranslatedFaxChar> result = new ArrayList<TranslatedFaxChar>();
		for (int value : numbers) {
			TranslatedFaxChar item = new TranslatedFaxChar(FaxCharConstants.EIGHT, value);
			result.add(item);
		}
		return result;
	}

}
