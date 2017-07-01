package binarySearch;

public class sqrt {
	public int mySqrt(int x) {
		if(x == 0 | x == 1){
            return x;
        }
        int start = 0;
        int end = x;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(mid > x / mid){
                end = mid - 1;
            }else if(mid == x / mid){
                return mid;
            }else{
                start = mid + 1;
            }
        }
        return start - 1;
	}

}
// 看完模板之后改的程序：
//比较两者之间的区别
/*
public class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int start = 1;
        int end = x;
        int mid = 0;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(mid == x / mid){
                start = mid;
            }else if(mid > x / mid){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(end <= x / end){
            return end;
        }else{
            return start;
        }
        
    }
}
*/
