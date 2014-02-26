package com.reebayroo.parsing;

import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.io.LineIterator;
import org.junit.Before;
import org.junit.Test;

public class FaxLineFactoryTest {

	private FaxLineFactory factory;
	@Before
	public void setup(){
		this.factory = new FaxLineFactory();
	}
	@Test
	public void testCreateNext() {
		String s = "line1\nline2\nline3\nline4\nline5\nline6\nline7\nline8";
		Reader reader = new StringReader(s );
		LineIterator lineIterator = new LineIterator(reader );
		FaxLine line = factory.createNext(lineIterator );
		
		assertEquals(new FaxLine("line1", "line2", "line3"), line);

		assertTrue(lineIterator.hasNext());
		
		FaxLine secondLine = factory.createNext(lineIterator);
		assertEquals(new FaxLine("line5", "line6", "line7"), secondLine);
		assertFalse(lineIterator.hasNext());
	}
	@Test
	public void testCreateIrregularLine() {
		String s = "line1\nline2";
		Reader reader = new StringReader(s );
		LineIterator lineIterator = new LineIterator(reader );
		FaxLine line = factory.createNext(lineIterator );
		assertEquals(new FaxLine("line1", "line2", ""), line);
		assertFalse(lineIterator.hasNext());
	}
}
