package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//碰到这种陌生的题 不要紧张啊！！！！ 慢慢分析出思路 既然是group 那你怎么去group
//我觉得想到hashtable是理所当然的 那么就去想我的key是什么 shifted string的特征是什么
//可以很自然的联想到每一位减去一个常数之后可以变成相同string的就是shifted的
public class GroupShiftedString {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            int dif = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = (char)(str.charAt(i) - dif);
                if (c < 'a') {
                    c += 26;
                }
                sb.append(c);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
	}
}
