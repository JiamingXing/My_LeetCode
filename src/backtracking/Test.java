package backtracking;

public class Test {
	int a;
	public Test(int a) {
		this.a = a;
	}
	public void addOne() {
		a ++;
		System.out.println(a);
	}
	public static void main(String[] args) {
		int a = 1;
		Test t = new Test(a);
		t.addOne();
		System.out.println(a);
	}

}
