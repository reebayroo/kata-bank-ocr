package com.reebayroo.account;

import java.io.PrintStream;

public class AccountPrinter {
	private final PrintStream out;

	public AccountPrinter(PrintStream out) {
		this.out = out;
	}

	public AccountPrinter() {
		this(System.out);
	}

	public void print(AccountNumber accountNumber) {
		out.print(accountNumber.generateDescriptionString());
	}

}
