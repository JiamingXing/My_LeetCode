
public class test3 {
	public static void main(String[] args) {
		getArrayIndex ary = new getArrayIndex();
		//a.array[] = [1 2 3 4 5 6];
		ary.array = new int[]{1,2,3,6,5,4};
		//int a[] = new int[]{1,2,3,6,5,4};
		int x =4;
		int result = ary.getAryIndex(x, ary.array);
		//int result = ary.getAryIndex(x, a);
		System.out.println(result);
		//不调用另一个class，直接在主函数外面写 method 可以吗？
		
		
		
		
	}

}
