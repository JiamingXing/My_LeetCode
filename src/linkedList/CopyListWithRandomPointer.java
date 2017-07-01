package linkedList;
//return a deep copy of this list
//拿到这道题的时候不知道这道题是什么意思。。 难点在哪里
//仔细一想感觉是 如果先做next的copy 那么random pointer copy无法通过label识别
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		//涉及对reference的理解。。
		//copy next list to a new single list
		RandomListNode iter = head;
		RandomListNode next = head;
		while (iter != null) {
			next = iter.next;
			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;
			iter = next;
		}
		//random pointer 
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random;
			}
			iter.next.random = iter.random.next;
			iter = iter.next.next;
		}
		// extract the list
		iter = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode copy = dummy;
		RandomListNode copyIter = dummy;
		while (iter != null) {
			//防止信息丢失先存储原list的信息
			next = iter.next.next;
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;
			
			//restore the original linkedlist
			iter.next = next;
			iter = next;
			//好好体会一下这道题 我觉得很精髓
		}
		return dummy;
	}

}
