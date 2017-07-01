package string;
//题目理解不到位
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
	}

}

/*
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		for (int i = 0; i <= magazine.length() - ransomNote.length(); i++) {
			if (magazine.substring(i, i + ransomNote.length()).equals(ransomNote)) {
				return true;
			}
		}
		return false;
	}

}
*/