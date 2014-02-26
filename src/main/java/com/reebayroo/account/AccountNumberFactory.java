package com.reebayroo.account;

import java.util.List;

import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountNumberFactory {

	private AccountCheckSumChecker checkSumChecker;
	private AccountInvalidNumberChecker invalidNumberChecker;
	private AccountNumberRestorer accountNumberRestorer;

	public AccountNumberFactory() {
		this(new AccountCheckSumChecker(), //
		        new AccountInvalidNumberChecker(), //
		        new AccountNumberRestorer());
	}

	public AccountNumberFactory(AccountCheckSumChecker checkSumChecker, //
	        AccountInvalidNumberChecker invalidNumberChecker,//
	        AccountNumberRestorer accountNumberRestorer) {
		this.checkSumChecker = checkSumChecker;
		this.invalidNumberChecker = invalidNumberChecker;
		this.accountNumberRestorer = accountNumberRestorer;
	}

	public AccountNumber createAccountNumber(List<DecoratedFaxDigit> parsedChars) {
		AccountNumber result = new AccountNumber(parsedChars, calcStatus(parsedChars));
		return restoreIfCorrupt(result);
	}

	private AccountNumber restoreIfCorrupt(AccountNumber accountNumber) {
		if (AccountNumberStatus.OK.equals(accountNumber.getStatus())) {
			return accountNumber;
		}
		return accountNumberRestorer.restore(accountNumber);
	}

	private AccountNumberStatus calcStatus(List<DecoratedFaxDigit> parsedChars) {
		return (!invalidNumberChecker.eval(parsedChars)) ? //
		AccountNumberStatus.ILL
		        : (!checkSumChecker.eval(parsedChars)) ? //
		        AccountNumberStatus.ERR
		                : AccountNumberStatus.OK;
	}

}
