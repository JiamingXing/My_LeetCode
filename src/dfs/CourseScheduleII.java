package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<Integer> temp = new ArrayList<>();
		boolean[][] relation = new boolean[numCourses][numCourses];
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int cur = prerequisites[i][0];
			int pre = prerequisites[i][1];
			//pre -> cur
			relation[pre][cur] = true;
			inDegree[cur] ++;
		}
		int res = 0;
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				Q.add(i);
			}
		}
		while (!Q.isEmpty()) {
			int course = Q.poll();
			temp.add(course);
			res ++;
			for (int j = 0; j < numCourses; j++) {
				if (relation[course][j]) {
					inDegree[j] --;
					if (inDegree[j] == 0) {
						Q.add(j);
					}
				}
			}
		}
		int[] result = new int[numCourses];
		if (res != numCourses) {
			return new int[0];
		} else {
			for (int i = 0; i < numCourses; i++) {
				result[i] = temp.get(i);
			}
			return result;
		}
	}
}
