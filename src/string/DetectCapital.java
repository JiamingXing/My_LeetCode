package string;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		return word.equals(word.toUpperCase()) ||
				word.equals(word.toLowerCase()) ||
				Character.isUpperCase(word.charAt(0)) &&
				word.substring(1).equals(word.substring(1).toLowerCase());
	}
}


//use regex? regex = regular expresssion
/*
public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
}
*/
