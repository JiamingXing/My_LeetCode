package string;

public class StudengAttendanceRecordI {
	public boolean checkRecord(String s) {
		int countA = 0;
		int countL = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'L') {
				countL ++;
				while (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i)) {
					countL ++;
					i ++;
				}
				if (countL > 2 ) {
					return false;
				}
				countL = 0;
			}
			if (c == 'A') {
				countA ++;
				if (countA > 1) {
					return false;
				}
			}
			
		}
		return true;
	}

}
