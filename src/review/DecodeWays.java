package review;
//DP
public class DecodeWays {
	public int numDecodings(String s) {
		if(s.length() == 0 || s == null){
			return 0;
		}
        int[] temp = new int[s.length() + 1];
		temp[0] = 1;
		temp[1] = s.charAt(0) == '0' ? 0 : 1;
		for(int i = 2; i < temp.length; i ++){
			int first = Integer.valueOf(s.substring(i-1, i));
			int second = Integer.valueOf(s.substring(i-2, i));
			if(first >= 1 && first <= 9){
				temp[i] += temp[i-1];
			}
			if(second >= 10 && second <= 26){
				temp[i] += temp[i-2];
			}
		}
		return temp[s.length()];
	}
}
