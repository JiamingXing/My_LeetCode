package hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < wall.size(); i++) {
			List<Integer> list = wall.get(i);
			int temp = 0;
			for (int j = 0; j < list.size()-1; j++) {
				int n = list.get(j);
				temp += n;
				map.put(temp, map.getOrDefault(temp, 0)+1);
				max = Math.max(max, map.get(temp));
			}
		}
		return wall.size() - max;
	}
}
