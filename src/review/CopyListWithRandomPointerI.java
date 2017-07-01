package review;

public class CopyListWithRandomPointerI {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode iter = head;
		while (iter != null) {
			RandomListNode next = iter.next;
			iter.next = new RandomListNode(iter.lable);
			iter.next.next = next;
			iter = next;
		}
		
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
		iter = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode copy = dummy;
		while (iter != null) {
			RandomListNode next = iter.next.next;
			copy.next = iter.next;
			copy = copy.next;
			iter.next = next;
			iter = next;
		}
		return dummy.next;
	}
}
