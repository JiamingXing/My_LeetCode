package review;
//word1 word2 could be the same word but distinct in words
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int index = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && ((word1.equals(word2)) || !words[index].equals(words[i]))) {
					min = Math.min(min, i - index);
				}
				index = i;
			}
		}
		return min;
	}
}
