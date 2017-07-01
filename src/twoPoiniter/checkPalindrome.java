package twoPoiniter;

public class checkPalindrome {
	public boolean isPalindrome(String s) {
		if(s.isEmpty()){
			return true;
		}
		int length = s.length();
		int i = 0;
		int j = length - 1;
		while(i < j){
			while(Character.isLetterOrDigit(s.charAt(i))){
				i ++;
			}
			while(Character.isLetterOrDigit(s.charAt(j))){
				j --;
			}
			if(convert(s.charAt(i)) == convert(s.charAt(j))){
				i ++;
				j --;
			}else{
				break;
			}
			
		}
		if(i > j){
			return true;
		}else{
			return false;
		}
	}
	public char convert(char c){
		if((int)c <= 90 && (int)c >=65){
			char temp = (char)((int)c + 32);
			return temp;
		}else{
			return c;
		}
	}
}
//很简单的一个程序各种错误，看看人家是怎么写的 规范性！
//变量名用的很有代表性，对于string character的方法很熟悉，变了溢出
//这里用while就是不行的，那么如何想到正确的思路来替换while？
/*
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
*/
