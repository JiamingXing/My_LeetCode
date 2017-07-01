package backtracking;

import java.util.ArrayList;
import java.util.List;
//别人的思路
public class GrayCode {
	public List<Integer> grayCode(int n) {
		 List<Integer> rs=new ArrayList<Integer>();
		 rs.add(0);
		 for(int i=0;i<n;i++){
			 int size=rs.size();
			 for(int k=size-1;k>=0;k--) {
				 rs.add(rs.get(k) | 1<<i); 
			 }
		 }
		 return rs;
	}
}
//另一种别人的思路 G(i) = i ^ (i/2)
/*
public List<Integer> grayCode(int n) {
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
    return result;
}
*/
