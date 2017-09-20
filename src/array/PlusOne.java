package array;

import java.util.ArrayList;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[0];
		}
		int len = digits.length;
		ArrayList<Integer> list = new ArrayList<>();
		int tag = digits[len-1] + 1 > 10 ? 1 : 0;
		list.add(digits[len-1] + 1 >= 10 ? (digits[len-1]-9) : digits[len-1]+1);
		for (int i = len - 2; i >= 0; i--) {
			list.add(digits[i] + tag >= 10 ? (digits[i]+tag-10) : digits[i]+tag);
			tag = digits[i] + tag >= 10 ? 1:0;
		}
		if (tag == 1) {
			list.add(1);
		}
		int[] res = new int[list.size()];
		int j = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			res[j++] = list.get(i);
		}
		return res;
	}
}

/*
public int[] plusOne(int[] digits) {
    
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}
*/
