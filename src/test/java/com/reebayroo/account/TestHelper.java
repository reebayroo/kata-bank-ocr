package com.reebayroo.account;

import java.util.ArrayList;
import java.util.List;

import com.reebayroo.parsing.FaxDigit;
import com.reebayroo.parsing.FaxDigitDictionary;
import com.reebayroo.parsing.DecoratedFaxDigit;

public class TestHelper {

	private static final FaxDigit INVALID_FAX_DIGIT = new FaxDigit( //
			"   ",//
			"   ",//
			"  |");
	public static List<DecoratedFaxDigit> createDigits(int... numbers) {
		List<DecoratedFaxDigit> result = new ArrayList<DecoratedFaxDigit>();
		for (int value : numbers) {
			DecoratedFaxDigit item = new DecoratedFaxDigit(
					(value > -1 ?
					FaxDigitDictionary.getInstance().getByValue(value) : //
					INVALID_FAX_DIGIT)
					, value);
			result.add(item);
		}
		return result;
	}

	public static AccountNumber createErr(int... numbers){
		return new AccountNumber(createDigits(numbers), AccountNumberStatus.ERR);
	}
	public static AccountNumber createIll(int... numbers){
		return new AccountNumber(createDigits(numbers), AccountNumberStatus.ILL);
	}
	public static AccountNumber createOK(int... numbers){
		return new AccountNumber(createDigits(numbers), AccountNumberStatus.OK);
	}
}
