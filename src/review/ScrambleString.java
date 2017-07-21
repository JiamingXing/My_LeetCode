package review;
//区间型动态规划
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		//state: 
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		
	}
}
