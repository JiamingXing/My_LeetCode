package DynamicProgramming;
//Palindrome Partition II 
//这种写法会时间超时！！所以一定要用DP的做法！！
public class solution {
	public static void main(String[] args) {
		solution x = new solution();
		String s= new String("aab");
		System.out.println(x.cut(s));
	}
	
	
	public boolean isPalindrome(String s){
		if(s == null || s.length() ==0){
            return true;
        }
		int length = s.length();
		for(int i = 0, j = length-1; i < j; i ++, j --){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	public int cut(String s){
		if(s.equals("")){
			return -1;
		}
		if(s.length() == 1){
			return 0;
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < s.length(); i++){
			int temp = 0;
			if(isPalindrome(s.substring(i, s.length()))){
				temp = cut(s.substring(0, i)) + 1;
				result = Math.min(result, temp);
			}
			
		}
		return result;
	}

}
