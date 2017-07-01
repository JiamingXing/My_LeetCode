package review;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		int[] temp = new int[26];
		for(int i = 0; i < s.length(); i++) {
			temp[s.charAt(i) - 'a'] ++;
		}
		for(int i = 0; i < t.length(); i++) {
			temp[t.charAt(i) - 'a'] --;
			if(temp[t.charAt(i) - 'a'] < 0){
				return false;
			}
		}
		return true;
	}

}
