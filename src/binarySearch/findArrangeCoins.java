package binarySearch;

public class findArrangeCoins {
	public int arrangeCoins(int n) {
		if(n == 0){
            return n;
        }
        int start = 1;
        int end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(0.5 * mid * mid + 0.5 * mid <= n){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(0.5 * end * end + 0.5 * end <= n){
            return end;
        }else{
            return start;
        }
	}
}
//数学的方法会更简单。。。
/*
public class Solution {
public int arrangeCoins(int n) {
    return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
}
}
*/