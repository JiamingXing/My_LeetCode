package geedyAlgotirhm;
//如何证明这个算法？
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        //如果总的cost 大于 gas 必然不能
        for (int i = 0; i < gas.length; i++) {
        	sum += gas[i] - cost[i];
        }
        if (sum < 0) {
        	return -1;
        }
        //反之肯定可以 接下来的任务是找start
        int start = 0;
        int accumulate = 0;
        for (int i = 0; i < gas.length; i++) {
        	int curSum = gas[i] - cost[i];
        	//如果从当前节点开始不能到达下一个节点 start = i + 1;
        	if (accumulate + curSum < 0) {
        		start = i+1;
        		accumulate = 0;
        	} else {
        		accumulate += curSum;
        	}
        }
        return start;
    }
}
