package com.reebayroo.account;

import java.util.List;

import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountNumber {

	private final List<DecoratedFaxDigit> decoratedFaxDigits;
	private final AccountNumberStatus status;

	public AccountNumber(List<DecoratedFaxDigit> decoratedFaxDigits, AccountNumberStatus status) {
		this.decoratedFaxDigits = decoratedFaxDigits;
		this.status = status;
	}

	public List<DecoratedFaxDigit> getDecoratedFaxDigits() {
		return decoratedFaxDigits;
	}

	public AccountNumberStatus getStatus() {
		return status;
	}

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((decoratedFaxDigits == null) ? 0 : decoratedFaxDigits.hashCode());
	    result = prime * result + ((status == null) ? 0 : status.hashCode());
	    return result;
    }

	@Override
    public boolean equals(Object obj) {
		//@formatter:off
	    if (this == obj) { return true; }
	    if (obj == null) { return false; }
	    if (!(obj instanceof AccountNumber)) { return false; }
	    AccountNumber other = (AccountNumber) obj;
	    if (decoratedFaxDigits == null) {
		    if (other.decoratedFaxDigits != null) {
			    return false;
		    }
	    } else if (!decoratedFaxDigits.equals(other.decoratedFaxDigits)) {
		    return false;
	    }
	    if (status != other.status) {
		    return false;
	    }
	    return true;
    }

	@Override
    public String toString() {
	    return "AccountNumber [decoratedFaxDigits=" + decoratedFaxDigits + ", status=" + status + "]";
    }

	 

}
