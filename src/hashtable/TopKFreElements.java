package hashtable;
//觉得这道题和SortCharacterByFre 很像 主要都考察对list的熟悉程度
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//磕磕绊绊做出来了但是时间复杂度不是很理想 有没有更好地办法
//而且黄色叹号的问题考虑一下 list真的可以那么用吗？
public class TopKFreElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxCount = 0;
		for (int i:nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
			maxCount = Math.max(maxCount, map.get(i));
		}
//		List<List<Integer>> temp = new ArrayList<>();
//		for (int key : map.keySet()) {
//			//这个地方没有提前设定list的长度不能这么弄
//			if (temp.get(map.get(key)) == null) {
//				List<Integer> list = new ArrayList<>();
//				temp.add(map.get(key), list);
//			}
//			temp.get(map.get(key)).add(key);
//		}
		List<Integer>[] list = new List[maxCount + 1];
		for (int key : map.keySet()) {
			int index = map.get(key);
			if (list[index] == null) {
				list[index] = new ArrayList<>();
			}
			list[index].add(key);
		}
		int[] array = new int[map.keySet().size()]; 
		int index = 0;
		for (int i = maxCount; i >= 0; i--) {
			//一开始没写这个if 导致出现了null pointer的错误
			//好好反思一下 为什么会没考虑这个情况
			if( list[i] == null) {
				continue;
			}
			for(int j = 0; j < list[i].size(); j++) {
				array[index] = list[i].get(j);
				index ++;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(array[i]);
		}
		return result;
	}

}



/*
//use an array to save numbers into different bucket whose index is the frequency
public class Solution {
 public List<Integer> topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
     for(int n: nums){
         map.put(n, map.getOrDefault(n,0)+1);
     }
     
     // corner case: if there is only one number in nums, we need the bucket has index 1.
     List<Integer>[] bucket = new List[nums.length+1];
     for(int n:map.keySet()){
         int freq = map.get(n);
         if(bucket[freq]==null)
             bucket[freq] = new LinkedList<>();
         bucket[freq].add(n);
     }
     
     List<Integer> res = new LinkedList<>();
     for(int i=bucket.length-1; i>0 && k>0; --i){
         if(bucket[i]!=null){
             List<Integer> list = bucket[i]; 
             res.addAll(list);
             k-= list.size();
         }
     }
     
     return res;
 }
}



//use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class Solution {
 public List<Integer> topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
     for(int n: nums){
         map.put(n, map.getOrDefault(n,0)+1);
     }
        
     PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                      new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
     for(Map.Entry<Integer,Integer> entry: map.entrySet()){
         maxHeap.add(entry);
     }
     
     List<Integer> res = new ArrayList<>();
     while(res.size()<k){
         Map.Entry<Integer, Integer> entry = maxHeap.poll();
         res.add(entry.getKey());
     }
     return res;
 }
}



//use treeMap. Use freqncy as the key so we can get all freqencies in order
public class Solution {
 public List<Integer> topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
     for(int n: nums){
         map.put(n, map.getOrDefault(n,0)+1);
     }
     
     TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
     for(int num : map.keySet()){
        int freq = map.get(num);
        if(!freqMap.containsKey(freq)){
            freqMap.put(freq, new LinkedList<>());
        }
        freqMap.get(freq).add(num);
     }
     
     List<Integer> res = new ArrayList<>();
     while(res.size()<k){
         Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
         res.addAll(entry.getValue());
     }
     return res;
 }
}
*/
