package hashtable;

public class BullAndCow {
	public String getHint(String secret, String guess) {
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] digit = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			digit[Character.getNumericValue(secret.charAt(i))] ++;
		}
		int bull = 0;
		int cow = 0;
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				bull ++;
				digit[Character.getNumericValue(secret.charAt(i))] --;
			}
		}
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				continue;
			}
			if (digit[Character.getNumericValue(guess.charAt(i))] > 0) {
				cow ++;
				digit[Character.getNumericValue(guess.charAt(i))] --;
			}
		}
		return (bull + "A" + cow + "B");
	}
	// "1122" "1222"的case没通过 输出"3A1B" expected:"3A0B"
	// 之后循环了两遍通过了 但是时间有点久 有没有更好地办法？
	//因为我写的是two pass  可以用one pass来写
}



/*
public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}
*/
