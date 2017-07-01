package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class SimplifyPaths {
	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		if (paths.length == 0) {
			return "/";
		}
		Deque<String> stack = new LinkedList<>();
		for (String s : paths) {
			if (s.equals(".")) {
				continue;
			} else if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (s.equals("")){
				continue;
			} else {
				stack.push(s);
			}
		}
		String res = "";
		for (String s : stack) {
			res = "/" + s + res;
		}
		return res.isEmpty() ? "/" : res;
//		Deque<String> stack = new LinkedList<>();
//	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
//	    for (String dir : path.split("/")) {
//	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
//	        else if (!skip.contains(dir)) stack.push(dir);
//	    }
//	    String res = "";
//	    for (String dir : stack) res = "/" + dir + res;
//	    return res.isEmpty() ? "/" : res;
	}
}

/*
public String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
    for (String dir : path.split("/")) {
        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
        else if (!skip.contains(dir)) stack.push(dir);
    }
    String res = "";
    for (String dir : stack) res = "/" + dir + res;
    return res.isEmpty() ? "/" : res;
}
*/
