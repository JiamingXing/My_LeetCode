package array;
//还没做出来的题
//怎么自己写comparator的排序？
import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		List<Interval> res = new ArrayList<>();
		//最关键的是没有写过这部分 第一次接触 如何sort
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		int firstStart = intervals.get(0).start;
		int firstEnd = intervals.get(0).end;
		for (int i = 0; i < intervals.size(); i++) {
			firstStart = intervals.get(i).start;
			firstEnd = intervals.get(i).end;
			while (i+1 < intervals.size() && intervals.get(i+1).start <= firstEnd) {
				firstEnd = Math.max(firstEnd, intervals.get(i+1).end);
				i ++;
			}
			res.add(new Interval(firstStart, firstEnd));
		}
		return res;
	}
}

//这是最快的思路 分别sort start和end
//我和具体顺序无关 我只要考虑整体的interval就可以了
//如果我start[i+1] <= end[i]我就往下合并
/*
public List<Interval> merge(List<Interval> intervals) {
	// sort start&end
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
	for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
		if (i == n - 1 || starts[i + 1] > ends[i]) {
			res.add(new Interval(starts[j], ends[i]));
			j = i + 1;
		}
	}
	return res;
}
*/


//别人的思路 
/*
public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1)
        return intervals;
    
    // Sort by ascending starting point using an anonymous Comparator
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    
    List<Interval> result = new LinkedList<Interval>();
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;
    
    for (Interval interval : intervals) {
        if (interval.start <= end) // Overlapping intervals, move the end if needed
            end = Math.max(end, interval.end);
        else {                     // Disjoint intervals, add the previous one and reset bounds
            result.add(new Interval(start, end));
            start = interval.start;
            end = interval.end;
        }
    }
    
    // Add the last interval
    result.add(new Interval(start, end));
    return result;
}
*/
