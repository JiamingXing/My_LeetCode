package twoPoiniter;

public class VakudPalindrome {
	public boolean isPalindrome(String s) {
		if(s.isEmpty() || s.length() == 1){
			return true;
		}
		int length = s.length();
		int i = 0;
		int j = length - 1;
		while(i <= j){
			if(!Character.isLetterOrDigit(s.charAt(i))){
				i ++;
			}else if(!Character.isLetterOrDigit(s.charAt(j))){
			    j --;
			}else{
			    if(convert(s.charAt(i)) != convert(s.charAt(j))){
			        return false;
			    }
			    i ++;
			    j --;
			}

		}
		return true;
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
