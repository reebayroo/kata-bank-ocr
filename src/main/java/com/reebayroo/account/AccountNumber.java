package com.reebayroo.account;

import java.util.List;

import com.reebayroo.parsing.TranslatedFaxChar;

public class AccountNumber {

	private final List<TranslatedFaxChar> parsedFaxChars;
	private final AccountNumberStatus status;

	public AccountNumber(List<TranslatedFaxChar> parsedFaxChars, AccountNumberStatus status) {
		this.parsedFaxChars = parsedFaxChars;
		this.status = status;
	}

	public List<TranslatedFaxChar> getParsedFaxChars() {
		return parsedFaxChars;
	}

	public AccountNumberStatus getStatus() {
		return status;
	}

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((parsedFaxChars == null) ? 0 : parsedFaxChars.hashCode());
	    result = prime * result + ((status == null) ? 0 : status.hashCode());
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
	    if (!(obj instanceof AccountNumber)) {
		    return false;
	    }
	    AccountNumber other = (AccountNumber) obj;
	    if (parsedFaxChars == null) {
		    if (other.parsedFaxChars != null) {
			    return false;
		    }
	    } else if (!parsedFaxChars.equals(other.parsedFaxChars)) {
		    return false;
	    }
	    if (status != other.status) {
		    return false;
	    }
	    return true;
    }

	@Override
    public String toString() {
	    return "AccountNumber [parsedFaxChars=" + parsedFaxChars + ", status=" + status + "]";
    }

}
