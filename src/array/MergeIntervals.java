package array;
//还没做出来的题
import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval first = intervals.get(i);
			while (i+1 <intervals.size() && intervals.get(i+1).start <= first.end && intervals.get(i+1).end >= first.start) {
				first = new Interval(Math.min(first.start, intervals.get(i+1).start), Math.max(first.end, intervals.get(i+1).end));
				i ++;
			}
			res.add(first);
		}
		return res;
	}
}
