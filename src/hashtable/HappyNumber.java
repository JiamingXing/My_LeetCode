package hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (set.add(n)) {
			int squareSum = 0;
			while (n > 0) {
				squareSum += (n % 10) * (n % 10);
				n = n / 10;
			}
			if (squareSum == 1) {
				return true;
			} else {
				n = squareSum;
			}
		}
		return false;
	}

}
