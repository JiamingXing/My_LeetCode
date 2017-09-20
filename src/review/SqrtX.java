package review;
//这道题不难想用二分法求解，最后返回什么可以自己拿一些简单的test case尝试
public class SqrtX {
	public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 0;
        int end = x;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            } else if (mid == x / mid) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return start - 1;
    }
}
