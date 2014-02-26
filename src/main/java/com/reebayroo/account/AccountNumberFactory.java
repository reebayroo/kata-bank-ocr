package com.reebayroo.account;

import java.util.List;

import com.reebayroo.parsing.TranslatedFaxChar;

public class AccountNumberFactory {

	private AccountCheckSumChecker checkSumChecker;
	private AccountInvalidNumberChecker invalidNumberChecker;

	public AccountNumberFactory(AccountCheckSumChecker checkSumChecker, AccountInvalidNumberChecker invalidNumberChecker) {
		this.checkSumChecker = checkSumChecker;
		this.invalidNumberChecker = invalidNumberChecker;
	}

	public AccountNumberFactory() {
		this.checkSumChecker = new AccountCheckSumChecker();
		this.invalidNumberChecker = new AccountInvalidNumberChecker();
	}

	public AccountNumber createAccountNumber(List<TranslatedFaxChar> parsedChars) {
		return new AccountNumber(parsedChars, calcStatus(parsedChars));
	}

	private AccountNumberStatus calcStatus(List<TranslatedFaxChar> parsedChars) {
		return (!invalidNumberChecker.eval(parsedChars)) ? //
		AccountNumberStatus.ILL
		        : (!checkSumChecker.eval(parsedChars)) ? //
		        AccountNumberStatus.ERR
		                : AccountNumberStatus.OK;
	}

}
