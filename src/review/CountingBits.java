package review;
//这道题是怎么找到DP的方程的f[i] = f[i/2] + i%2
//二进制的问题还是要和位运算结合在一起分析
public class CountingBits {
	public int[] countBits(int num) {
		int[] result  = new int[num+1];
		 for(int i = 0; i <= num; i ++){
			 result[i] = result[i/2] + i%2;
		 }
		 return result;
	}
}

/*
public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}
*/
