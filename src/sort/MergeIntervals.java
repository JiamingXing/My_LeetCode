package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
	    int[] starts = new int[n];
	    int[] ends = new int[n];
	    for (int i = 0; i < n; i++) {
		    starts[i] = intervals.get(i).start;
		    ends[i] = intervals.get(i).end;
	    }
	    Arrays.sort(starts);
	    Arrays.sort(ends);
	    // loop through
	    List<Interval> res = new ArrayList<Interval>();
	    //start of current interval
        int j = 0;
	    for (int i = 0; i < n; i++) {
            if (i == n - 1 || starts[i+1] > ends[i]) {
            	res.add(new Interval(starts[j], ends[i]));
            	j = i + 1;
            }
        }
	    return res;
    }
}
