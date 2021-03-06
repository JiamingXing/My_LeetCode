package hashtable;

public class CountPrimes {
	public int countPrimes(int n) {
		//初始化一个boolean array 里面存的都是false
		boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
	}

}
