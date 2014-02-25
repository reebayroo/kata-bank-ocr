package com.reebayroo.parsing;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

class FaxCharBook {
	public static final FaxChar ZERO = new FaxChar( //
	        " _ ",//
	        "| |",//
	        "|_|");
	public static final FaxChar ONE = new FaxChar( //
	        "   ",//
	        "  |",//
	        "  |");
	public static final FaxChar TWO = new FaxChar( //
	        " _ ",//
	        " _|",//
	        "|_ ");
	public static final FaxChar THREE = new FaxChar( //
	        " _ ",//
	        " _|",//
	        " _|");
	public static final FaxChar FOUR = new FaxChar( //
	        "   ",//
	        "|_|",//
	        "  |");
	public static final FaxChar FIVE = new FaxChar( //
	        " _ ",//
	        "|_ ",//
	        " _|");
	public static final FaxChar SIX = new FaxChar( //
	        " _ ",//
	        "|_ ",//
	        "|_|");
	public static final FaxChar SEVEN = new FaxChar( //
	        " _ ",//
	        "  |",//
	        "  |");
	public static final FaxChar EIGHT = new FaxChar( //
	        " _ ",//
	        "|_|",//
	        "|_|");
	public static final FaxChar NIVE = new FaxChar( //
	        " _ ",//
	        "|_|",//
	        " _|");

	private static FaxCharBook instance = null;
	private Map<FaxChar, Integer> book = new HashMap<FaxChar, Integer>();

	private FaxCharBook() {
		book.put(FaxCharBook.ZERO, Integer.valueOf(0));
		book.put(FaxCharBook.ONE, Integer.valueOf(1));
		book.put(FaxCharBook.TWO, Integer.valueOf(2));
		book.put(FaxCharBook.THREE, Integer.valueOf(3));
		book.put(FaxCharBook.FOUR, Integer.valueOf(4));
		book.put(FaxCharBook.FIVE, Integer.valueOf(5));
		book.put(FaxCharBook.SIX, Integer.valueOf(6));
		book.put(FaxCharBook.SEVEN, Integer.valueOf(7));
		book.put(FaxCharBook.EIGHT, Integer.valueOf(8));
		book.put(FaxCharBook.NIVE, Integer.valueOf(9));
	}

	public static FaxCharBook getInstance() {
		if (instance == null) {
			instance = new FaxCharBook();
		}
		return instance;
	}

	public boolean contains(FaxChar faxChar) {
		return book.containsKey(faxChar);
	}

	public Integer get(FaxChar faxChar) {
		Validate.isTrue(contains(faxChar), "invalid");
		return book.get(faxChar);
	}

}
