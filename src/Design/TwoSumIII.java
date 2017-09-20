package Design;
//如果我们加一个list去maintain distinct elements会快不少
import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
	Map<Integer, Integer> map;
	
	/** Initialize your data structure here. */
    public TwoSumIII() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int n : map.keySet()) {
            int temp = value - n;
            if ((temp == n && map.get(n) > 1) || (temp != n && map.containsKey(temp))) {
                return true;
            }
        }
        return false;
    }
}
