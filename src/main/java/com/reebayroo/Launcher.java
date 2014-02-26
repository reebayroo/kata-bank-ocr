package com.reebayroo;

import java.util.List;

import org.apache.commons.io.LineIterator;

import com.reebayroo.account.AccountNumber;
import com.reebayroo.account.AccountNumberFactory;
import com.reebayroo.account.AccountPrinter;
import com.reebayroo.parsing.FaxChar;
import com.reebayroo.parsing.FaxCharExtractor;
import com.reebayroo.parsing.FaxLine;
import com.reebayroo.parsing.FaxLineFactory;
import com.reebayroo.parsing.FaxCharTranslator;
import com.reebayroo.parsing.TranslatedFaxChar;

public class Launcher {
	private FaxCharExtractor faxCharExtractor;
	private FaxLineFactory faxLineFactory;
	private FaxCharTranslator faxCharTranslator;
	private AccountNumberFactory accountNumberFactory;
	private AccountPrinter accountPrinter;

	public Launcher(FaxCharExtractor faxCharExtractor, FaxLineFactory faxLineFactory, FaxCharTranslator faxCharTranslator, AccountNumberFactory accountNumberFactory,
	        AccountPrinter accountPrinter) {
		this.faxCharExtractor = faxCharExtractor;
		this.faxLineFactory = faxLineFactory;
		this.faxCharTranslator = faxCharTranslator;
		this.accountNumberFactory = accountNumberFactory;
		this.accountPrinter = accountPrinter;
	}

	public Launcher() {
		this(new FaxCharExtractor(), new FaxLineFactory(), new FaxCharTranslator(), new AccountNumberFactory(), new AccountPrinter());
	}

	public void run(LineIterator lineIterator) {
		while (lineIterator.hasNext()) {
			FaxLine line = faxLineFactory.createNext(lineIterator);
			List<FaxChar> faxChars = faxCharExtractor.parse(line);
			List<TranslatedFaxChar> translated = faxCharTranslator.translate(faxChars);
			AccountNumber accountNumber = accountNumberFactory.createAccountNumber(translated);
			accountPrinter.print(accountNumber);
		}

	}

}
