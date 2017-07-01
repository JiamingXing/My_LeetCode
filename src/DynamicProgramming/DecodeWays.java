package DynamicProgramming;
//有想法但是需要对String的操作很熟悉(Integer.valueOf)
//对于这样一道题，对于DP的感触就是第一步如果划分小规模问题
//需要灵感和经验 自己的最初想法是类似于recursion但是会很慢很复杂
//如何想到利用长度作为中介进行DP
//0的情况怎么处理 第一个char是0？？题目描述有点奇怪。。

//单序列DP：(单序列DP的问题有什么普遍特点方便我们去判断一道题是否用单序列DP做？)
//state：f[i]表示前i个位置的数字/字母/
public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays x = new DecodeWays();
		String s = new String("12031111");
		System.out.println(x.numDecodings(s));
	}
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
