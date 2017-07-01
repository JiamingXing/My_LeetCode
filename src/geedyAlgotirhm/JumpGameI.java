package geedyAlgotirhm;
//写这道题之后有有个很严重的问题
//刷题到现在经常碰到第一次编译不能通过的情况
//说明写程序写完之后检查的习惯很差 而且出现问题之后如何debug没有经验
public class JumpGameI {
	public boolean canJump(int[] nums) {
		int curReach = 0;
		while(curReach < nums.length - 1){
			if(curReach + nums[curReach] >= nums.length - 1){
				return true;
			}
			// find new curReach
			// 思路是在当前位置在所有可以到达位置中选能到达最远的那个index
			//碰到0怎么办，会永久循环
			int temp = 0;
			int max = 0;
			int gap = 0;
			for(int i = 1; i <= nums[curReach]; i ++){
				//加一个gap的tag 如果后面所有可以抵达的index处都为0
				//就直接返回false，因为无法继续
				if(nums[curReach + i] > gap){
				    gap = nums[curReach + i];
				}
				if(i + nums[curReach + i] > max){
					max = i + nums[curReach + i];
					temp = curReach + i;
				}
			}
			if(gap == 0){
			    return false;
			}
			curReach = temp;
		}
		return false;
	}
}
//感觉自己写的程序有点繁琐 不够精炼，对比别人写的程序，总结学习一下
/*
public class solution{
	public boolean canJump(int[] A){
		if(A == null || A.length == 0){
			return false;
		}
		int farthest = A[0];
		for(int i = 1; i < farthest; i ++){
			if(i <= farthest && A[i] + i >= farthest){
				farthest = A[i] + i;
			}
		}
		return farthest >= A.length - 1;
	}
}
*/
//
//可以用贪心算法解决的问题，都可以用动态规划解决
//但是可以用动态规划解决的问题不一定可以用贪心算法解决
//贪心算法的局限性会大很多
//对于这道题 贪心算法的时间复杂度是O(n) 而动态规划的时间复杂度是O(n^2)
//想一想这道题如何用动态规划解决

//Dynamic programming
//本质上如果用动态规划实现是否存在某个方案的问题
//就是实现OR操作
//像之前的求最大最小用max min操作
//求方案总和，用加法实现
/*
public class solution{
	public boolean canJump(int[] A){
		boolean[] can = new boolean[A.length];
		can[0] = true;
		for(int i = 1; i < A.length; i ++){
			for(int j = 0; j < i; j ++){
				if(can[j] && j + A[j] >= i){
					can[i] = true;
					break;
				}
			}
		}
		return can[A.length - 1];
	}
}
*/

