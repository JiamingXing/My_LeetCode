package review;

public class StudentAttendanceRecordII {
	public int checkRecord(int n) {
        int M = 1000000007;
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;
        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }
        //长度为n没有A的情况的通过方案总数
        long res = PorL[n];
        //所有一个A的情况
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
    	    long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }
        return (int) res;
    }
}
