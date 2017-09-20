package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//public class TopKFrequentElements {
//	public List<Integer> topKFrequent(int[] nums, int k) {
//		List<Integer> res = new ArrayList<>();
//		Map<Integer, Integer> map = new HashMap<>();
//		int max = 0;
//		for (int n : nums) {
//			map.put(n, map.getOrDefault(n, 0)+1);
//			max = Math.max(max, map.get(n));
//		}
//		List<Integer>[] bucket = new ArrayList[max+1];
//		for (int key : map.keySet()) {
//			if (bucket[map.get(key)] == null) {
//				bucket[map.get(key)] = new ArrayList<>();
//			}
//			bucket[map.get(key)].add(key);
//		}
//		for (int i = max; i > 0; i --) {
//			List<Integer> list = bucket[i];
//			if (list != null) {
//				for (int s : list) {
//					res.add(s);
//					k--;
//					if (k == 0) {
//						break;
//					}
//				}
//			}
//			if (k == 0) {
//				break;
//			}
//		}
//		return res;
//	}
//}


public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
				new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}
		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}
}
