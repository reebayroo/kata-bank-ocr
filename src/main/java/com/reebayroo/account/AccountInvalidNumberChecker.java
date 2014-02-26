package com.reebayroo.account;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountInvalidNumberChecker {
	public boolean eval(List<DecoratedFaxDigit> parsedFaxChars) {
		if (CollectionUtils.isEmpty(parsedFaxChars)) {
			return false;
		}

		List<DecoratedFaxDigit> l = parsedFaxChars;
		for (DecoratedFaxDigit parsedFaxChar : l) {
			if (parsedFaxChar.getValue() < 0) {
				return false;
			}
		}
		return true;

	}
}
