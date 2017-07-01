import java.util.ArrayList;
import java.util.List;

public class combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
        helper(result, temp, n, k, 1);
        return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> temp, int n, int k, int p){
		
		if(k == 0){
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i = p; i <= n; i ++){
			temp.add(i);
			helper(result, temp, n, k - 1, i+1);
			temp.remove(temp.size()-1);
		}
		
	}

}
