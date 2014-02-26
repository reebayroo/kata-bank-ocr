package com.reebayroo;

import java.util.List;

import org.apache.commons.io.LineIterator;

import com.reebayroo.account.AccountNumber;
import com.reebayroo.account.AccountNumberFactory;
import com.reebayroo.account.AccountPrinter;
import com.reebayroo.parsing.FaxDigit;
import com.reebayroo.parsing.FaxDigitExtractor;
import com.reebayroo.parsing.FaxDigitDecorator;
import com.reebayroo.parsing.FaxLine;
import com.reebayroo.parsing.FaxLineFactory;
import com.reebayroo.parsing.DecoratedFaxDigit;

public class Launcher {
	private FaxDigitExtractor faxDigitExtractor;
	private FaxLineFactory faxLineFactory;
	private FaxDigitDecorator faxDigitDecorator;
	private AccountNumberFactory accountNumberFactory;
	private AccountPrinter accountPrinter;

	public Launcher(FaxDigitExtractor faxDigitExtractor, FaxLineFactory faxLineFactory, //
	        FaxDigitDecorator faxDigitDecorator, AccountNumberFactory accountNumberFactory, AccountPrinter accountPrinter) {
		this.faxDigitExtractor = faxDigitExtractor;
		this.faxLineFactory = faxLineFactory;
		this.faxDigitDecorator = faxDigitDecorator;
		this.accountNumberFactory = accountNumberFactory;
		this.accountPrinter = accountPrinter;
	}

	public Launcher() {
		// Who miss Spring?!??! Anyone?!
		this(new FaxDigitExtractor(), //
		        new FaxLineFactory(), //
		        new FaxDigitDecorator(), //
		        new AccountNumberFactory(), //
		        new AccountPrinter());
	}

	public void run(LineIterator lineIterator) {
		while (lineIterator.hasNext()) {
			FaxLine line = faxLineFactory.createNext(lineIterator);
			List<FaxDigit> faxDigits = faxDigitExtractor.parse(line);
			List<DecoratedFaxDigit> translated = faxDigitDecorator.translate(faxDigits);
			AccountNumber accountNumber = accountNumberFactory.createAccountNumber(translated);

			accountPrinter.print(accountNumber);
		}

	}

}
