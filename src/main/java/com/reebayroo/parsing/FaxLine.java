package com.reebayroo.parsing;

public class FaxLine {
	private final String firstLine;
	private final String secondLine;
	private final String thirdLine;

	public FaxLine(String firstLine, String secondLine, String thirdLine) {
	    super();
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
	    result = prime * result + ((firstLine == null) ? 0 : firstLine.hashCode());
	    result = prime * result + ((secondLine == null) ? 0 : secondLine.hashCode());
	    result = prime * result + ((thirdLine == null) ? 0 : thirdLine.hashCode());
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
	    if (firstLine == null) {
		    if (other.firstLine != null) {
			    return false;
		    }
	    } else if (!firstLine.equals(other.firstLine)) {
		    return false;
	    }
	    if (secondLine == null) {
		    if (other.secondLine != null) {
			    return false;
		    }
	    } else if (!secondLine.equals(other.secondLine)) {
		    return false;
	    }
	    if (thirdLine == null) {
		    if (other.thirdLine != null) {
			    return false;
		    }
	    } else if (!thirdLine.equals(other.thirdLine)) {
		    return false;
	    }
	    return true;
    }

}
