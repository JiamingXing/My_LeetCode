package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//对于每一个start 都有一个对应的大于start的end
//merge的时候和start和end的一一对应关系无关
public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		//这个方法更快一点
//		int[] start = new int[res.size()];
//		int[] end = new int[res.size()];
//		for (int i = 0; i < res.size(); i++) {
//			Interval cur = res.get(i);
//			start[i] = cur.start;
//			end[i] = cur.end;
// 		}
//		Arrays.sort(start);
//		Arrays.sort(end);
//		int left = 0;
//		for (int i = 0; i < res.size(); i++) {
//			if (i == res.size() - 1 || start[i+1] > end[i]) {
//				res.add(new Interval(start[left], end[i]));
//				left = i+1;
//			}
//		}
//		return res;
		if (intervals == null || intervals.size() == 0) {
            return res;
        }
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		//别忘了最后一个start end的interval是没被计算进去的
		res.add(new Interval(start, end));
		return res;
	}
}
