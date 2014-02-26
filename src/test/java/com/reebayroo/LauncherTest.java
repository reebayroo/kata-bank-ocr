package com.reebayroo;

import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.apache.commons.io.LineIterator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.reebayroo.account.AccountNumber;
import com.reebayroo.account.AccountNumberFactory;
import com.reebayroo.account.AccountPrinter;
import com.reebayroo.parsing.FaxDigit;
import com.reebayroo.parsing.FaxDigitExtractor;
import com.reebayroo.parsing.FaxLine;
import com.reebayroo.parsing.FaxLineFactory;
import com.reebayroo.parsing.FaxDigitDecorator;
import com.reebayroo.parsing.DecoratedFaxDigit;

public class LauncherTest {
	private Launcher launcher;
	private FaxDigitExtractor faxDigitExtractor;
	private FaxLineFactory faxLineFactory;
	private FaxDigitDecorator faxDigitDecorator;
	private AccountNumberFactory accountNumberFactory;
	private AccountPrinter accountPrinter;

	@Before
	public void setup() {
		this.faxDigitExtractor = Mockito.mock(FaxDigitExtractor.class);
		this.faxLineFactory = Mockito.mock(FaxLineFactory.class);
		this.faxDigitDecorator = Mockito.mock(FaxDigitDecorator.class);
		this.accountNumberFactory = Mockito.mock(AccountNumberFactory.class);
		this.accountPrinter = Mockito.mock(AccountPrinter.class);
		this.launcher = new Launcher(faxDigitExtractor, faxLineFactory, faxDigitDecorator, accountNumberFactory, accountPrinter);

	}

	/*
	 * I really don't like the test so closely coupled with implementation!
	 */
    @Test
    @SuppressWarnings("unchecked")
	public void test() {
		String s = "line1\n";
		Reader reader = new StringReader(s);
		final LineIterator lineIterator = new LineIterator(reader);
		Mockito.when(faxLineFactory.createNext(lineIterator)).thenAnswer(new Answer<FaxLine>() {

			public FaxLine answer(InvocationOnMock invocation) throws Throwable {
				LineIterator passedLineIterator = (LineIterator) invocation.getArguments()[0];
				passedLineIterator.nextLine();
				return new FaxLine("", "","");
            }
		});
		
		launcher.run(lineIterator);
		
		Mockito.verify(faxDigitExtractor).parse(Mockito.isA(FaxLine.class));
		Mockito.verify(faxDigitDecorator).translate(Mockito.anyList()) ;
		Mockito.verify(accountNumberFactory).createAccountNumber(Mockito.anyList());
		

	}

}
