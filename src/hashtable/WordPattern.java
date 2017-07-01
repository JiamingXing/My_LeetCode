package hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if(words.length != pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		for(int i = 0; i < words.length; i ++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(words[i])){
					return false;
				}
			}else{
				if(map.containsValue(words[i])){
					return false;
				}
				map.put(pattern.charAt(i), words[i]);
			}
			
		}
		//还要考虑不同的key 对应的value必须不同的问题
		//所以这样的写法有问题
		//加一句contains value解决问题
		return true;
	}

}
