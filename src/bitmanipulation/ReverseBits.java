package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

//follow up: if this function is called many times, how would u optimize it?
//public class ReverseBits {
//	public int reverseBits(int n) {
//		int res = 0;
//		for (int i = 0; i < 32; i++) {
//			res += n & 1;
//			// must do unsigned shift
//			n >>>= 1;
//			if (n < 1) {
//				//for last digit do not shift
//				res <<= 1;
//			}
//		}
//		return res;
//	}
//}

//bit byte的概念
//总体的思路还是不变的 我每次都得到最后一位数字 -- 和1与的方法，然后加到res上，向左移位
//这道题体现了 & 在bit manipulation中的作用 就是提取数字，因为不管什么数字和1与都是其本身
public class ReverseBits {
	private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
	public int reverseBits(int n) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			//0x表示十六进制 FF表示二进制的11111111 
			bytes[i] = (byte) ((n >>> 8*i) & 0xFF);
		}
		int res = 0;
		for (int i = 0; i < 4; i++) {
			res += reverseByte(bytes[i]);
			if (i < 3) {
				res <<= 8;
			}
		}
		return res;
	}
	private int reverseByte(byte b) {
		Integer value = cache.get(b);
		if (value != null) {
			return value;
		}
		value = 0;
		for (int i = 0; i < 8; i++) {
			value += ((b >>> i) & 1);
			if (i < 7) {
				value <<= 1;
			}
		}
		cache.put(b, value);
		return value;
	}
}
