package com.reebayroo.parsing;

import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

public class FaxLineFactory {

	public FaxLine createNext(LineIterator lineIterator) {
		FaxLine result = new FaxLine(extraLine(lineIterator),
								extraLine(lineIterator),
								extraLine(lineIterator));
		//The forth line
		extraLine(lineIterator);
	    return result;
    }

	private String extraLine(LineIterator lineIterator) {
	    return lineIterator.hasNext()? lineIterator.nextLine() : StringUtils.EMPTY;
    }

}
