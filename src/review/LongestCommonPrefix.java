package review;
//这是最直接的思路 因为我要找所有String的longest common prefix 所以我以第一个
//string作为对象操作，但是如果第一个string很长？
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
			i ++;
		}
		return pre;
	}
}


//sort一个String[] array的结果是怎么样的？
//sort之后是一个alphabetical sorted array如果存在prefix 那么只要找第一个元素
//和最后一个元素之间的prefix就可以了
/*
public String longestCommonPrefix(String[] strs) {
    StringBuilder result = new StringBuilder();
    
    if (strs!= null && strs.length > 0){
    
        Arrays.sort(strs);
        
        char [] a = strs[0].toCharArray();
        char [] b = strs[strs.length-1].toCharArray();
        
        for (int i = 0; i < a.length; i ++){
            if (b.length > i && b[i] == a[i]){
                result.append(b[i]);
            }
            else {
                return result.toString();
            }
        }
    return result.toString();
}
*/