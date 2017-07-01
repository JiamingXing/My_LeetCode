package init;
public class HammingDistance {
	int count = 0;
	public int hammingDistance(int x, int y) {
		int z = x ^ y;
        for(int i=0;i<32;i++){
            count = count + (z & 1);
            z = z >>1;
        }
        return count;
	}

}
