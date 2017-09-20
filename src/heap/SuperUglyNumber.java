package heap;

import java.util.PriorityQueue;

//用priority queue
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		PriorityQueue<Num> Q = new PriorityQueue<>();
		for (int i = 0; i < primes.length; i++) {
			Q.add(new Num(primes[i], i, primes[i]));
		}
		for (int i = 1; i < n; i++) {
			ugly[i] = Q.peek().val;
			while (Q.peek().val == ugly[i]) {
				Num cur = Q.poll();
				Q.add(new Num(ugly[cur.ind]*cur.factor, cur.ind+1, cur.factor));
			}
		}
		return ugly[n-1];
	}
	private class Num implements Comparable<Num> {
		int val;
		int ind;
		int factor;
		public Num(int val, int ind, int factor) {
			this.val = val;
			this.ind = ind;
			this.factor = factor;
		}
		
		@Override
		public int compareTo(Num that) {
			return this.val - that.val;
		}
	}
}



//ugly number II 的思路
/*
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n];
		dp[0] = 1;
		int k = primes.length;
		int[] index = new int[k];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < index.length; j ++) {
				dp[i] = Math.min(dp[i], dp[index[j]] * primes[j]);
			}
			for (int j = 0; j < index.length; j++) {
				if (dp[index[j]] * primes[j] == dp[i]) {
					index[j] ++;
				}
			}
		}
		return dp[n - 1];
	}
}
*/
