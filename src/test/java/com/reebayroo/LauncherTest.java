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
import com.reebayroo.parsing.FaxChar;
import com.reebayroo.parsing.FaxCharExtractor;
import com.reebayroo.parsing.FaxLine;
import com.reebayroo.parsing.FaxLineFactory;
import com.reebayroo.parsing.FaxCharTranslator;
import com.reebayroo.parsing.TranslatedFaxChar;

public class LauncherTest {
	private Launcher launcher;
	private FaxCharExtractor faxCharExtractor;
	private FaxLineFactory faxLineFactory;
	private FaxCharTranslator faxCharTranslator;
	private AccountNumberFactory accountNumberFactory;
	private AccountPrinter accountPrinter;

	@Before
	public void setup() {
		this.faxCharExtractor = Mockito.mock(FaxCharExtractor.class);
		this.faxLineFactory = Mockito.mock(FaxLineFactory.class);
		this.faxCharTranslator = Mockito.mock(FaxCharTranslator.class);
		this.accountNumberFactory = Mockito.mock(AccountNumberFactory.class);
		this.accountPrinter = Mockito.mock(AccountPrinter.class);
		this.launcher = new Launcher(faxCharExtractor, faxLineFactory, faxCharTranslator, accountNumberFactory, accountPrinter);

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
		
		Mockito.verify(faxCharExtractor).parse(Mockito.isA(FaxLine.class));
		Mockito.verify(faxCharTranslator).translate(Mockito.anyList()) ;
		Mockito.verify(accountNumberFactory).createAccountNumber(Mockito.anyList());
		

	}

}
