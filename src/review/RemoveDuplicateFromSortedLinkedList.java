package review;

public class RemoveDuplicateFromSortedLinkedList {
//	public ListNode deleteDuplicates(ListNode head) {
//		if (head == null || head.next == null) {
//			return head;
//		}
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
//		head = dummy;
//		while (head != null && head.next != null) {
//			head = head.next;
//			while (head.next != null && head.val == head.next.val) {
//				head.next = head.next.next;
//			}
//		}
//		return dummy.next;
//	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}
			//从第一个不重复节点开始
			cur = cur.next;
		}
		return head;
	}
}

/*
public class RemoveDuplicateFromSortedLinkedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		//while循环条件一开始还写错了 应该要判断两个next 不为空
		while (head.next != null && head.next.next != null) {
			//跳到第一个不重复的元素上
			//所以对于循环开始的时候其实是判断两个next 这里要注意
			head = head.next;
			if (head.val == head.next.val) {
				int temp = head.val;
				//不断改变head.next的值 进行循环找到不是重读的为止
				while (head.next != null && head.next.val == temp) {
					head.next = head.next.next;
				}
			}
		}
		return dummy.next;
	}
}
*/

//自己review的时候写的 错误的写法
/*
public class RemoveDuplicateFromSortedLinkedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (head != null) {
			//这样的写法本质上就相当于跳过了最后一个点，所以肯定是不行的
			if (head.next != null && head.next.val == head.val) {
				head.next = head.next.next;
			}
			head = head.next;
		}
		return dummy.next;
	}
}
*/
