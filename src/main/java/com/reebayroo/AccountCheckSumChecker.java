package com.reebayroo;

public class AccountCheckSumChecker {

	public boolean eval(int[] account) {
		if (account == null || account.length != 9) return false;
		// 3 4 5 8 8 2 8 6 5
		// d9 d8 d7 d6 d5 d4 d3 d2 d1
		// (1*d1+2*d2+3*d3+4*d4+5*d5+6*d6+7*d7 + 8*d8 +9*d9) mod 11 = 0
		
		int result = 0;
		for (int i = 0, j = 9; i < 9; i++) {
			result += account[i] * j--;
		}
		return result % 11 == 0;
	}

}
