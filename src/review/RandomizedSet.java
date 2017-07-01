package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Map<Integer, Integer> map;
	List<Integer> list;
	/** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
        	return false;
        } else {
        	map.put(val, list.size());
        	list.add(val);
        	return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
        	int pos = map.get(val);
        	if (pos < list.size() - 1) {
        		int temp = list.get(list.size() - 1);
        		list.set(pos, temp);
        		map.put(temp, pos);
        	}
        	list.remove(list.size() - 1);
        	map.remove(val);
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
