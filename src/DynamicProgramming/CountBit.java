package DynamicProgramming;
//关键在于能找到dp[i] = dp[i/2] + i%2;
public class CountBit {
	 public int[] countBits(int num) {
		 int[] result  = new int[num+1];
		 for(int i = 0; i <= num; i ++){
			 result[i] = result[i/2] + i%2;
		 }
		 return result;
	 }

}
