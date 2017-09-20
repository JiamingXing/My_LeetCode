package math;
//花的时间有点长。。 反应能快一些吗？
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int res = 0;
        int height = 0;
        int width = 0;
        res += (C - A ) * (D - B);
        res += (H - F) * (G - E);
        if (H <= B || F >= D || G <= A || E >= C) {
            return res;
        } else {
            height = Math.min(D, H) - Math.max(B, F);
            width = Math.min(C, G) - Math.max(A, E);
            res -= (height * width);
        }
        return res;
	}
}
