package review;
//这道题完全没有自己的思路 感觉答案的思路太巧妙了
public class TrappingRainWater {
	public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (start <= end) {
        	leftMax = Math.max(leftMax, height[start]);
        	rightMax = Math.max(rightMax, height[end]);
        	if (leftMax < rightMax) {
        		max += leftMax - height[start];
        		start ++;
        	} else {
        		max += rightMax - height[end];
        		end --;
        	}
        }
        return max;
    }
}
