package linkedList;
//在链表上做插入的操作比数组要简单很多 复杂度O(1)
//在数字上为O(n)
//这道题就用到linked list 可以随便改变next的特性
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode leftDummy = new ListNode(0);
		ListNode left = leftDummy;
		ListNode rightDummy = new ListNode(0);
		ListNode right = rightDummy;
		while(head != null ){
			if(head.val < x){
				left.next = head;
				left = head;
				head = head.next;
			}else{
				right.next = head;
				right = head;
				head = head.next;
			}
		}
		right.next = null;
		left.next = rightDummy.next;
		return leftDummy.next;
	}
 
}
