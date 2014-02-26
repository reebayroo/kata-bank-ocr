package com.reebayroo.account;

import java.io.PrintStream;

import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountPrinter {
	private final PrintStream out;

	public AccountPrinter(PrintStream out) {
		this.out = out;
	}

	public AccountPrinter() {
		this(System.out);
	}

	public void print(AccountNumber accountNumber) {
		out.print(generateDescriptionString(accountNumber));;
	}

	private String generateDescriptionString(AccountNumber accountNumber) {
		StringBuilder builder = new StringBuilder();
		for (DecoratedFaxDigit decoratedFaxDigit : accountNumber.getDecoratedFaxDigits()) {
	        builder.append(getValueOrQM(decoratedFaxDigit.getValue()));
        }
		builder.append(" ").append(accountNumber.getStatus());
	    return builder.toString();
	  }

	private Object getValueOrQM(int value) {
		return value > -1? value : "?";
    }

}
