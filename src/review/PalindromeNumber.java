package review;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (x < 0) {
            return false;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head ++;
            tail --;
        }
        return true;
    }
}

/*
public class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
    	    rev = rev*10 + x%10;
    	    x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
*/
