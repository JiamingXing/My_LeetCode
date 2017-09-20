package hashtable;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
        int[] hash = new int[256];
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		while (right < s.length()) {
            hash[s.charAt(right)] ++;
            //只要我没有repeating Characters 我就计算长度 更新最大
            if (hash[s.charAt(right)] < 2) {
                max = Math.max(max, right-left+1);
                //如果出现重复了那我们去找重复的字符的位置
            } else {
                while (hash[s.charAt(right)] > 1) {
                    hash[s.charAt(left)] --;
                    left ++;
                }
            }
            right ++;
        }
		return max;
	}
}
