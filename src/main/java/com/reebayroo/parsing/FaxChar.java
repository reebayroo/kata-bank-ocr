package com.reebayroo.parsing;

import org.apache.commons.lang3.Validate;

public class FaxChar {
	private String lineOne;
	private String lineTwo;
	private String lineThree;

	public FaxChar(String lineOne, String lineTwo, String lineThree) {
		Validate.notEmpty(lineOne);
		Validate.notEmpty(lineTwo);
		Validate.notEmpty(lineThree);
		
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.lineThree = lineThree;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lineOne == null) ? 0 : lineOne.hashCode());
        result = prime * result + ((lineThree == null) ? 0 : lineThree.hashCode());
        result = prime * result + ((lineTwo == null) ? 0 : lineTwo.hashCode());
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
        if (!(obj instanceof FaxChar)) {
	        return false;
        }
        FaxChar other = (FaxChar) obj;
        if (lineOne == null) {
	        if (other.lineOne != null) {
		        return false;
	        }
        } else if (!lineOne.equals(other.lineOne)) {
	        return false;
        }
        if (lineThree == null) {
	        if (other.lineThree != null) {
		        return false;
	        }
        } else if (!lineThree.equals(other.lineThree)) {
	        return false;
        }
        if (lineTwo == null) {
	        if (other.lineTwo != null) {
		        return false;
	        }
        } else if (!lineTwo.equals(other.lineTwo)) {
	        return false;
        }
        return true;
    }

	@Override
    public String toString() {
	    return "FaxChar [\n." + lineOne + ".\n." + lineTwo + ".\n." + lineThree + ".\n.]";
    }
	
}