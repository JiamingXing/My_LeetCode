package review;

import java.util.ArrayList;
import java.util.List;

//不管几进制的加法都可以用这个方法来写，就是按照最基本的定义写，并且耐心
//写法还是参照discuss里的写法 自己的写法太冗长 不够简练
//discuss里的写法是用位运算完成的
//如果是其他进制的可能就要按照自己的写法来完成
public class AddBinary {
	public String addBinary(String a, String b) {
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();
		int aPos = a.length() - 1;
		int bPos = b.length() - 1;
		int tag = 0;
		List<Integer> list = new ArrayList<>();
		while (aPos >= 0 || bPos >=0) {
			list.add(((aPos >= 0 ? Character.getNumericValue(cha[aPos]) : 0)  +
					(bPos >= 0 ? Character.getNumericValue(chb[bPos]) : 0)  +
							tag) % 2);
			tag = ((aPos >= 0 ? Character.getNumericValue(cha[aPos]) : 0)  +
					(bPos >= 0 ? Character.getNumericValue(chb[bPos]) : 0)  +
							tag) / 2;
		    aPos --;
		    bPos --;
		}
		if (tag == 1) {
			list.add(1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i) + "");
		}
		return sb.toString();
	}
}

/*
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}
*/
