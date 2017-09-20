package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPariswithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        for (int i = 0; i < (nums2.length > k ? k : nums2.length); i++) {
            Q.add(new Pair(nums1[0] + nums2[i], 0, i));
        }
        //一直到Queue为止
        for (int i = 0; i < k && !Q.isEmpty(); i++) {
            Pair cur = Q.poll();
            res.add(new int[]{nums1[cur.ind1], nums2[cur.ind2]});
            //防止溢出 就是K比所有可能pair总数还多
            if (cur.ind1 == nums1.length - 1) {
                continue;
            }
            Q.add(new Pair(nums1[cur.ind1+1] + nums2[cur.ind2], cur.ind1+1, cur.ind2));
        }
        return res;
    }
    private class Pair implements Comparable<Pair>{
        int val;
        int ind1;
        int ind2;
        public Pair(int val, int ind1, int ind2) {
            this.val = val;
            this.ind1 = ind1;
            this.ind2 = ind2;
        }
        
        @Override
        public int compareTo(Pair that) {
            return this.val - that.val;
        }
    }
}
