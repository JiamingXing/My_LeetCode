package backtracking;
import java.util.ArrayList;
// IP:a.b.c.d <255
// DFS的做法？ 其实暴力解法是最好的。。做什么题可以都先考虑一下暴力解法
import java.util.List;

public class RestoreIP {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12) {
			return res;
		}
		StringBuilder sb = new StringBuilder();
		helper(res, sb, s, 0);
		return res;
	}
	private void helper(List<String> res, StringBuilder sb, String s, int tag) {
		if (tag > 3) {
			if (s.equals("")) {
				res.add(sb.toString());
			}
			return;
		}
		//i <= s.length() 一开始写成<发现一直输出空的list 不够细心
		for (int i = 1; i <= 3 && i <= s.length(); i++) {
			String st = s.substring(0, i);
			int len = sb.length();
			if (Integer.parseInt(st) <= 255 ) {
				//做这一次if判断continue非常非常关键！
				//因为比如"025"parseInt的结果是25 但是在IP中是not allowed
				if (st.charAt(0) == '0' && st.length() > 1) {
					continue;
				}
				tag ++;
				if (tag < 4) {
					sb.append(st).append(".");
				} else {
					sb.append(st);
				}
				String rest = s.substring(i, s.length());
				helper(res, sb, rest, tag);
				sb.setLength(len);
				tag --;
			}
		}
	}
}
/*
public class RestoreIP {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12) {
			return res;
		}
		StringBuilder sb = new StringBuilder();
		helper(res, sb, s, 0);
		return res;
	}
	private void helper(List<String> res, StringBuilder sb, String s, int tag) {
		if (tag > 4) {
			if (s.equals("")) {
				StringBuilder ssb = new StringBuilder(sb);
				res.add(ssb.toString());
			}
			return;
		}
		for (int i = 1; i <= 3 && i < s.length(); i++) {
			String st = s.substring(0, i);
			int len = sb.length();
			if (Integer.parseInt(st) <= 255) {
				tag ++;
				if (tag < 4) {
					sb.append(st).append(".");
				} else {
					sb.append(st);
				}
				String rest = s.substring(i, s.length());
				helper(res, sb, rest, tag);
				sb.setLength(len);
				tag --;
			}
		}
	}
}
*/


/*
public class Solution {
public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    if(s.length() < 4 || s.length() > 12)
        return result;
    restoreIpAddresses(s, 0, 4, result, new StringBuilder());
    return result;
}
public void restoreIpAddresses(String s, int index, int set, List<String>result, StringBuilder sb){
    if(index > s.length() || s.length() - index < set ||s.length() - index > set*3){
        return;
    }else if(index == s.length()){
        sb.setLength(sb.length()-1);
        result.add(sb.toString());
        return;
    }
    int len = sb.length();
    for(int i = 1; i <=3 ; i++){
        if(index+i <= s.length() && 
           (i!=3 || Integer.parseInt(s.substring(index, index+i))< 256) &&
           (i==1 || Integer.parseInt(s.substring(index, index+1))!= 0)) 
        {
            sb.append(s.substring(index, index+i)+".");
            restoreIpAddresses(s, index+i, set-1, result, sb);
            sb.setLength(len);
        }
    }
}
*/
