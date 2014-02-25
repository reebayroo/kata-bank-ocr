package com.reebayroo.parsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class FaxCharTranslator {
	public List<TranslatedFaxChar> translate(List<FaxChar> faxChars) {
		Validate.notEmpty(faxChars, "Expecting a valid list of chars");
		List<TranslatedFaxChar> result = new ArrayList<TranslatedFaxChar>();
		for (FaxChar faxChar : faxChars) {
			result.add(new TranslatedFaxChar(faxChar, //
			        FaxCharBook.getInstance().contains(faxChar) ? //
			        FaxCharBook.getInstance().get(faxChar)
			                : -1));
		}
		return result;
	}
}
