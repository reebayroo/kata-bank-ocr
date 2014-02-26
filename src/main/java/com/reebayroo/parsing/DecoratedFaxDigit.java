package com.reebayroo.parsing;

import org.apache.commons.lang3.Validate;

public class DecoratedFaxDigit {
	private final FaxDigit originalDigit;
	private final Integer value;

	public DecoratedFaxDigit(FaxDigit originalDigit, Integer value) {
		Validate.notNull(originalDigit);
		Validate.notNull(value);
		this.originalDigit = originalDigit;
		this.value = value;
	}

	public FaxDigit getOriginalDigit() {
		return originalDigit;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + originalDigit.hashCode();
		result = prime * result + value.hashCode();
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
		if (!(obj instanceof DecoratedFaxDigit)) {
			return false;
		}
		DecoratedFaxDigit other = (DecoratedFaxDigit) obj;
		if (!originalDigit.equals(other.originalDigit)) {
			return false;
		}
		if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DecoratedFaxDigit [originalDigit=" + originalDigit + ", value=" + value + "]";
	}

}
