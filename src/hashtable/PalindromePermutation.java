package hashtable;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)] ++;
        }
        int tag = 0;
        for (int i = 0; i < 256; i++) {
            if (hash[i] == 1) {
                if (tag == 1) {
                    return false;
                } else {
                    tag = 1;
                }
            }
            if (hash[i] != 0 && hash[i] % 2 != 0) {
                return false;
            } 
        }
        return true;
    }
}
