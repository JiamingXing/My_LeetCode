package hashtable;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		//这里为什么要把int数据类型转换成long？
		//为了handle overflow?
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		
		sb.append(num/den);
		num %= den;
		if (num == 0) {
			return sb.toString();
		}
		
		sb.append(".");
		Map<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());
		while (num != 0) {
			num = num * 10;
			sb.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(")");
				break;
			} else {
				map.put(num, sb.length());
			}
		}
		return sb.toString();
	}

}




//其实这道题看起来不难 但是考察了一个人思维的严密性以及对字符串还有各种数据类型
//操作的熟练程度 好好体会一下
/*
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
*/
