package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//考阅读理解。。
public class FindDuplicateFileinSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> res = new ArrayList<>();
		if (paths.length == 0) {
			return res;
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] s = path.split("\\s+");
			for (int i = 1; i < s.length; i++) {
				int index = s[i].indexOf("(");
				String content = s[i].substring(index);
				String filename = s[0] + "/" + s[i].substring(0, index);
				if (!map.containsKey(content)) {
					map.put(content, new ArrayList<>());
				}
				map.get(content).add(filename);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				res.add(map.get(key));
			}
		}
		return res;
	}
}
