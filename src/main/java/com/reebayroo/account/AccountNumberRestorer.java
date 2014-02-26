package com.reebayroo.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.reebayroo.parsing.DecoratedFaxDigit;
import com.reebayroo.parsing.FaxDigitFixer;

public class AccountNumberRestorer {

	FaxDigitFixer fixer = new FaxDigitFixer();
	AccountCheckSumChecker checker = new AccountCheckSumChecker();

	public AccountNumber restore(AccountNumber accountNumber) {

		List<AccountNumber> newAccounts = new ArrayList<AccountNumber>();

		List<DecoratedFaxDigit> list = new ArrayList<DecoratedFaxDigit>(accountNumber.getDecoratedFaxDigits());

		DecoratedFaxDigit[] optionArray = createCopy(list);

		for (int i = 0; i < list.size(); i++) {
			List<DecoratedFaxDigit> options = fixer.findOptions(list.get(i));
			exploreOptions(newAccounts, optionArray, i, options);
		}
		return CollectionUtils.isNotEmpty(newAccounts) ? getSuggestionOrAmbivolent(accountNumber, newAccounts) : accountNumber;
	}

	private AccountNumber getSuggestionOrAmbivolent(AccountNumber accountNumber, List<AccountNumber> newAccounts) {
		return newAccounts.size() > 1 ? AccountNumber.createAmbAccount(accountNumber, newAccounts) : newAccounts.get(0);
	}

	private DecoratedFaxDigit[] createCopy(List<DecoratedFaxDigit> list) {
		DecoratedFaxDigit[] result = new DecoratedFaxDigit[list.size()];
		int i = 0;
		for (DecoratedFaxDigit decoratedFaxDigit : list) {
			result[i++] = decoratedFaxDigit;
		}
		return result;
	}

	private void exploreOptions(List<AccountNumber> newAccounts, DecoratedFaxDigit[] faxDigits, int index, List<DecoratedFaxDigit> options) {
		DecoratedFaxDigit original = faxDigits[index];
		for (DecoratedFaxDigit suggestion : options) {
			faxDigits[index] = suggestion;
			addIfWorks(newAccounts, faxDigits);
		}
		faxDigits[index] = original;
	}

	private void addIfWorks(List<AccountNumber> newAccounts, DecoratedFaxDigit[] faxDigits) {
		List<DecoratedFaxDigit> list = Arrays.asList(faxDigits);
		if (checker.eval(list)) {
			List<DecoratedFaxDigit> newList = new ArrayList<DecoratedFaxDigit>();
			newList.addAll(list);
			newAccounts.add(new AccountNumber(newList, AccountNumberStatus.OK));
		}
	}

}
