package array;

public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < timeSeries.length; i++) {
			res += (timeSeries[i] - timeSeries[i-1]) >= duration ? duration : (timeSeries[i] - timeSeries[i-1]);
		}
		return res + duration;
	}
}
