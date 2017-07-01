package review;

public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		char[] ch = s.toCharArray();
		int numA = 0;
		int numL = 0;
		for (int i = 0; i < ch.length; i++) {
			char cur = ch[i];
			if (cur == 'A') {
				numA ++;
				if (numA > 1) {
					return false;
				}
			}
			if (cur == 'L') {
				numL ++;
				while (i+1 < ch.length && ch[i+1] == cur) {
					numL ++;
					i ++;
				}
				if (numL > 2) {
					return false;
				}
				numL = 0;
			}
		}
		return true;
	}
}
