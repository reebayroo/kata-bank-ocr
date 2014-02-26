package com.reebayroo.parsing;

import org.apache.commons.lang3.Validate;

public class FaxLine {
	private final String firstLine;
	private final String secondLine;
	private final String thirdLine;

	public FaxLine(String firstLine, String secondLine, String thirdLine) {
		Validate.notNull(firstLine);
		Validate.notNull(secondLine);
		Validate.notNull(thirdLine);

		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.thirdLine = thirdLine;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public String getThirdLine() {
		return thirdLine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstLine.hashCode();
		result = prime * result + secondLine.hashCode();
		result = prime * result + thirdLine.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FaxLine)) {
			return false;
		}
		FaxLine other = (FaxLine) obj;
		if (!firstLine.equals(other.firstLine)) {
			return false;
		}
		if (!secondLine.equals(other.secondLine)) {
			return false;
		}
		if (!thirdLine.equals(other.thirdLine)) {
			return false;
		}
		return true;
	}

}
