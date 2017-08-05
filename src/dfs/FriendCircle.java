package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircle {
	public int findCircleNum(int[][] M) {
		int n = M.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> Q = new LinkedList<>();
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			Q.add(i);
			visited[i] = true;
			res ++;
			while (!Q.isEmpty()) {
				int cur = Q.poll();
				for (int j = 0; j < n; j++) {
					if (visited[j]) {
						continue;
					} else if (M[cur][j] == 1) {
						visited[j] = true;
						Q.add(j);
					}
				}
			}
		}
		return res;
	}

}




//这是一道典型的union find 题目 下面的参考程序可以作为模板
/*
public class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent, rank;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
        	while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}
*/




/*
public int findCircleNum(int[][] M) {
    int m = M.length, cnt = 0;
    int[] root = new int[m]; 
    for (int i = 0; i < m; i++) root[i] = i; 
    for (int i = 0; i < m; i++) 
        for (int j = i + 1; j < m; j++)
            if (M[i][j] == 1) unionFind(root, i, j);

    for (int i = 0; i < m; i++)
        if (i == root[i]) cnt++;
    return cnt;
}

void unionFind (int[] root, int v1, int v2) {
    while (root[v1] != v1) v1 = root[v1]; //find v1's root
    while (root[v2] != v2) v2 = root[v2]; //find v2's root
    if (root[v1] != root[v2]) root[v2] = v1; //unite the 2 subtrees 
}
*/