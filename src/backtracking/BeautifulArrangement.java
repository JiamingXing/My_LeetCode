package backtracking;
//别人的思路 而且还没有理解
//为什么自己想不到这种穷举遍历的思路
public class BeautifulArrangement {
	int count;
	public int countArrangement(int N) {
		if (N == 0) {
            return 0;
        }
        helper(N, 1, new int[N+1]);
        return count;
	}
	private void helper(int N, int pos, int[] nums) {
        if (pos > N) {
            count ++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (nums[i] == 0 && (i % pos ==0 || pos % i == 0)) {
                nums[i] = 1;
                helper(N, pos+1, nums);
                nums[i] = 0;
            }
        }
    }

}


//递归模板？
/*
helper (parameters of given data and current recursive level) {
    // Handle base cases, i.e. the last level of recursive call
    if (level == lastLevel) {
        record result;
        return sth;
    }
    // Otherwise permute every possible value for this level.
    for (every possible value for this level) {
        helper(parameters of given data and next recursive level);
    }
    return sth;
}
*/
