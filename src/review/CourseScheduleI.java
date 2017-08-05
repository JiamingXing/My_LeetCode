package review;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		boolean[][] relation = new boolean[numCourses][numCourses];
		int m = prerequisites.length;
		for (int i = 0; i < m; i++) {
			int pre = prerequisites[i][0];
			int cur = prerequisites[i][1];
			inDegree[cur] ++;
			relation[pre][cur] = true;
		}
		int res = 0;
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				Q.add(i);
			}
		}
		while (!Q.isEmpty()) {
			int pre = Q.poll();
			res ++;
			for (int i = 0; i < numCourses; i++) {
				if (relation[pre][i]) {
					inDegree[i] --;
					if (inDegree[i] == 0) {
						Q.offer(i);
					}
				}
			}
		}
		return res == numCourses;
	}
}
