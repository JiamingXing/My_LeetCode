package string;

import java.util.List;
/*
 * 这道题一开始好像自己想的太复杂了。。
public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		int length = timePoints.size();
		int[] dif = new int[length - 1];
		for (int i = 0; i < length -1; i++) {
			String time1 = timePoints.get(i);
			String time2 = timePoints.get(i+1);
			String[] st1 = time1.split(":");
			String[] st2 = time2.split(":");
			int temp =  Math.abs(Integer.parseInt(st1[0]) - Integer.parseInt(st2[0])) * 60 +
					Math.abs(Integer.parseInt(st1[1]) - Integer.parseInt(st2[1]));
			temp = temp > 720 ? 1440 - 720 : temp;
			if () {
				dif[i] = temp;
			} else {
				dif[i] = -temp;
			}
		}
		
	}
	private int minSumContiguousSubarray(int[] dif) {
		
	}

}
*/

//不要忘记还要把头尾再比一下
public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		boolean[] time = new boolean[24*60];
		for (String s : timePoints) {
			String[] st = s.split(":");
			int temp = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
			if (time[temp]) {
				return 0;
			} 
			time[temp] = true;
		}
		int prev = -1;
		int first = -1;
		int last = -1;
		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < 24 * 60; i++) {
			if (time[i]) {
				if (first == -1) {
					first = i;
				}
				if (prev != -1) {
					minimum = Math.min(minimum, i - prev);
				} 
				prev = i;
			}
		}
		last = prev;
		return Math.min(minimum, 24 * 60 - last + first);
	}
}
