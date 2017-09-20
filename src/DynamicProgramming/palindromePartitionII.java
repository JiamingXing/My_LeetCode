package DynamicProgramming;
//这道题和decode ways一样都属于单序列DP类的问题 一起总结思考一下！！
//state: f[i]:前i个字符需要多少次切割能变成回文
//0 -> "" empty string 
//1 -> "a" is a palindrome 0cut
//2 -> "aa" 0cut
//3 -> "aab" 1cut -> 1+f["a"] = 1
//长度和之前的长度状态有关系吗？？？？这个很关键
//another example s = "abacc"
//"abac|c" -> valid  = f["abac"] + 1
//"aba|cc" -> valid  = f["aba"] + 1;
//"ab|acc" -> invalid
//"a|bacc" -> invalid
//"|abacc" -> invalid
//相当于把5个字符的问题转换成了三个字符和四个字符的问题
//所以function: f[i] = Min(f[j] + 1) && j+1 ~ i is palindrome
//initialization: 
public class palindromePartitionII {
//	private boolean isPalindrome(String s, int start, int end){
//		for(int i = start, j = end; i < j; i ++, j --){
//			if(s.charAt(i) != s.charAt(j)){
//				return false;
//			}
//		}
//		return true;
//	}
	//这是一种区间型DP。。省了很多时间 思考下为什么 
	//区间型的关键在于找那个一直在增加的元素！：长度  
	private boolean[][] getIsPalindrome(String s){
		boolean[][] isPalingdrome = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++){
			isPalingdrome[i][i] = true;
		}
		for(int i = 0; i < s.length()-1; i ++){
			isPalingdrome[i][i+1] = (s.charAt(i) == s.charAt(i+1)); 
		}
		for(int length = 2; length < s.length(); length ++){
			for(int start = 2; start+length < s.length(); start++){
				isPalingdrome[start][start+length]
						= isPalingdrome[start + 1][start+length-1] && s.charAt(start) == s.charAt(start+length);
			}
		}
		return isPalingdrome;
	}
	
	public int minCut(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}
		//preparation
		boolean[][] isPalindrome = getIsPalindrome(s);
		
		//initialization
		int[] f = new int[s.length()+1];
		for(int i = 0; i <= s.length(); i++){
			f[i] = i - 1;//Integer.MAX_VALUE
		}
		//main
		for(int i = 1; i <= s.length(); i++){
			for(int j = 0; j < i; j ++){
				if(isPalindrome[j][i-1]){
					f[i] = Math.min(f[i], f[j]+1);
				}
			}
		}
		return f[s.length()];
	}

}
 