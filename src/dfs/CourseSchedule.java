package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//relation[i][j] ith course is jth course prerequisite?
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
		return res == numCourses;
	}
}
