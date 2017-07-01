package review;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode iter = head;
		RandomListNode next = head;
		//先把链表copy下来
		while(iter != null) {
			next = iter.next;
			RandomListNode copy = new RandomListNode(iter.lable);
			iter.next = copy;
			copy.next = next;
			iter = next;
		}
		//copy random pointer
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
		//extract the copied list
		iter = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode copy = dummy;
		RandomListNode copyIter = dummy;
		while (iter != null) {
			next = iter.next.next;
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;
			
			iter.next = next;
			iter = next;
		}
		return dummy.next;
	}
}
