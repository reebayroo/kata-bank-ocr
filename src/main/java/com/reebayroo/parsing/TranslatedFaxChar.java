package com.reebayroo.parsing;

public class TranslatedFaxChar {
	private final FaxChar originalChar;
	private final Integer value;

	public TranslatedFaxChar(FaxChar originalChar, Integer value) {
		this.originalChar = originalChar;
		this.value = value;
	}

	public FaxChar getOriginalChar() {
		return originalChar;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((originalChar == null) ? 0 : originalChar.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (!(obj instanceof TranslatedFaxChar)) {
			return false;
		}
		TranslatedFaxChar other = (TranslatedFaxChar) obj;
		if (originalChar == null) {
			if (other.originalChar != null) {
				return false;
			}
		} else if (!originalChar.equals(other.originalChar)) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

}
