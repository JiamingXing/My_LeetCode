package review;
//如果用DP这样写对吗？
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		boolean[][] dp = new boolean[s.length()+1][t.length()+1];
		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = false;
		}
		for (int i = 0; i <= t.length(); i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				dp[i][j] = dp[i][j-1];
				if (t.charAt(j-1) == s.charAt(i-1)) {
					dp[i][j] = dp[i][j] || dp[i-1][j-1];
				}
			}
		}
		return dp[s.length()][t.length()];
	}
}

/**
 * Follow-up
 * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t. 
 * This is inefficient. 
 * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t. 
 * Sounds like a HashMap, which is super suitable for search for existing stuff. 
 */
/*
public boolean isSubsequence(String s, String t) {
    if (s == null || t == null) return false;
    
    Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>
    
    //preprocess t
    for (int i = 0; i < t.length(); i++) {
        char curr = t.charAt(i);
        if (!map.containsKey(curr)) {
            map.put(curr, new ArrayList<Integer>());
        }
        map.get(curr).add(i);
    }
    
    int prev = -1;  //index of previous character
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        
        if (map.get(c) == null)  {
            return false;
        } else {
            List<Integer> list = map.get(c);
            prev = binarySearch(prev, list, 0, list.size() - 1);
            if (prev == -1) {
                return false;
            }
            prev++;
        }
    }
    
    return true;
}

private int binarySearch(int index, List<Integer> list, int start, int end) {
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (list.get(mid) < index) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    
    return start == list.size() ? -1 : list.get(start);
}
*/

//two pointer
/*
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}
*/

//改进版本
/*
public class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }
        
        return true;
    }
}
*/


//DP
/*
String tmp = s;
s = t;
t = tmp;

if (s == null || s.length() == 0){
    return t == null || t.length() == 0;
}

if (t == null || t.length() == 0){
    return true;
}

int m = t.length();
int n = s.length();

boolean[][] dp = new boolean[m][n];

//initial first col
if (t.charAt(0) == s.charAt(0)){
    dp[0][0] = true;
}

for (int i = 1 ; i < m ; i++){
    dp[i][0] = false;
}

//initial first row
for (int i = 1 ; i < n ; i++){
    dp[0][i] = dp[0][i-1] || (s.charAt(i) == t.charAt(0));
}

for (int i = 1 ; i < m ; i++){
    for (int j = 1 ; j < n ; j++){
        if (s.charAt(j) == t.charAt(i)){
            dp[i][j] = (dp[i-1][j-1] || dp[i][j-1]);
            //all others to be true and continue;
            if (dp[i][j]){
                for (int k = j + 1 ; k < n ; k++){
                    dp[i][k] = true;
                }
                continue;
            }
        }
    }
}

return dp[m-1][n-1];
}
*/
