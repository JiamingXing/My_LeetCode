package binarySearch;

//这样写是错的 比如6就不对
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


//这道题如果follow up要求你返回的double的值 那我们就改变条件while (|end - start| < 10 ^ -6)

//模板确实解决了这样的问题
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
