package com.reebayroo.account;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.Validate;

import com.reebayroo.parsing.DecoratedFaxDigit;

public class AccountNumber {

	private final List<DecoratedFaxDigit> decoratedFaxDigits;
	private final AccountNumberStatus status;
	private List<AccountNumber> alternatives;

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
	public String toString() {
		return "AccountNumber [decoratedFaxDigits=" + decoratedFaxDigits + ", status=" + status + "]";
	}

	public static AccountNumber createAmbAccount(AccountNumber original, List<AccountNumber> alternatives) {
		Validate.notEmpty(alternatives);
		Validate.isTrue(alternatives.size() > 1, "Expecting more than one alternative");
		AccountNumber result = new AccountNumber(original.decoratedFaxDigits, AccountNumberStatus.AMB);
		result.setAlternatives(alternatives);
		return result;
	}

	private void setAlternatives(List<AccountNumber> alternatives) {
		this.alternatives = alternatives;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternatives == null) ? 0 : alternatives.hashCode());
		result = prime * result + decoratedFaxDigits.hashCode();
		result = prime * result + status.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//@formatter:off
		if (this == obj) { return true; }
	    if (obj == null) { return false; }
	    if (!(obj instanceof AccountNumber)) { return false;   }
	    AccountNumber other = (AccountNumber) obj;
	    if (alternatives == null) {  if (other.alternatives != null) {  return false;  }
	    } else if (!alternatives.equals(other.alternatives)) {  return false;    }
	    if (!decoratedFaxDigits.equals(other.decoratedFaxDigits)) { return false;   }
	    if (status != other.status) { return false;   }
	    return true;
		//@formatter:on
	}

	public String generateDescriptionString() {
		StringBuilder builder = new StringBuilder();
		printDigits(builder, this);
		builder.append(" ").append(this.getStatus());
		if (CollectionUtils.isNotEmpty(this.alternatives)) {
			builder.append(generateAlternativesDescription());
		}
		return builder.toString();
	}

	private String generateAlternativesDescription() {
		String comma = "";
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		for (AccountNumber alternative : this.alternatives) {
			builder.append(comma);
			builder.append("'");
			printDigits(builder, alternative);
			builder.append("'");
			comma = ", ";
		}
		builder.append("]");
		return builder.toString();
	}

	private void printDigits(StringBuilder builder, AccountNumber accountNumber) {
		for (DecoratedFaxDigit decoratedFaxDigit : accountNumber.getDecoratedFaxDigits()) {
			builder.append(getValueOrQM(decoratedFaxDigit.getValue()));
		}
	}

	private Object getValueOrQM(int value) {
		return value > -1 ? value : "?";
	}

}
