package init;
public class toArrangeCoins {
	public int arrangeCoins(int n) {
		int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
        	//>>>移位运算符 二进制数右移 等价于(start + end) / 2
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
	}

}
//属于binary search 关键在于什么时候停止循环，想清楚这个条件很重要！
//一开始自己写的时候 while(start <= end)想不到 ，可能没有等于号
//怎么取尝试想出这个等于号
//这道题和写sqrt 根号的题思路一模一样 只要确实停止循环的条件就迎刃而解

//return (int) Math.floor((-1 + Math.sqrt(1+8L*n))/2.0);
//数学的方法。。。更简单