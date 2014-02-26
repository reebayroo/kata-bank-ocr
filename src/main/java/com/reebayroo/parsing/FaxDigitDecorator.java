package com.reebayroo.parsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class FaxDigitDecorator {
	public List<DecoratedFaxDigit> translate(List<FaxDigit> faxDigits) {
		Validate.notEmpty(faxDigits, "Expecting a valid list of chars");
		List<DecoratedFaxDigit> result = new ArrayList<DecoratedFaxDigit>();
		for (FaxDigit faxDigit : faxDigits) {
			result.add(new DecoratedFaxDigit(faxDigit, //
			        FaxDigitDictionary.getInstance().contains(faxDigit) ? //
			        FaxDigitDictionary.getInstance().get(faxDigit)
			                : -1));
		}
		return result;
	}
}
