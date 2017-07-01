package array;
//把数组变成正负交错的数组 不需要保持正数负数原来的顺序
public class InterleavingPositiveandNegativeNumbers {
	public void rerange(int[] A) {
		int[] count = new int[2];
		for (int n : A) {
			if (n > 0) {
				count[0] ++;
			} else {
				count[1] ++;
			}
		}
		int start = 0;
		int end = A.length - 1;
		int tag = 1;
		//考虑从正开始还是从负开始
		if (count[0] < count[1]) {
			tag = -1;
		}
		while (start <= end) {
			while (start <= end && A[start] * tag > 0) {
				start ++;
				tag = -tag;
			}
			while (start <= end && A[end] * tag < 0) {
				end --;
			}
			if (start <= end) {
				int temp = A[start];
				A[start] = A[end];
				A[end] = temp;
				start ++;
				end = A.length - 1;
				tag = -tag;
			}
		}
	}
}
