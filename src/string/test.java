package string;

import java.util.ArrayList;
import java.util.List;
//Integer这里产生异常 那么上面的hello不会输出出来？
public class test {
	public static void main(String[] args) {
//		List list = new ArrayList<>();
//		list.add("hello");
//		list.add(12);
//		for (int i = 0; i < list.size(); i++) {
//			String name = (String) list.get(i);
//			System.out.println(name);
//		}
		Integer a  = new Integer(100);
		System.out.println((long) a);
	}

}
