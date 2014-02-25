package com.reebayroo.account;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.reebayroo.parsing.TranslatedFaxChar;

public class AccountInvalidNumberChecker {
	public boolean eval(List<TranslatedFaxChar> parsedFaxChars) {
		if (CollectionUtils.isEmpty(parsedFaxChars)) {
			return false;
		}

		List<TranslatedFaxChar> l = parsedFaxChars;
		for (TranslatedFaxChar parsedFaxChar : l) {
			if (parsedFaxChar.getValue() < 0) {
				return false;
			}
		}
		return true;

	}
}
