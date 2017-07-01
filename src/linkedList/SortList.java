package linkedList;
//merge sort, quick sort and heap sort O(nlogn)
//list的排序用merge sort比较好
//Array的排序用quick sort比较好 因为quick sort是一个in-place的排序
//试着用quick sort的方法写一下sort list 然后写一下 quick sort 和 merge sort Array
public class SortList {
	 public ListNode sortList(ListNode head) {
		 if(head == null || head.next == null){
			 return head;
		 }
		 ListNode mid = findMiddle(head);
		 //这道题要求constant space 递归的空间不一定计算 看面试官要求
		 ListNode right = sortList(mid.next);
		 mid.next =null;
		 ListNode left = sortList(head);
		 return merge(left,right);
	 }
	 private ListNode findMiddle(ListNode head){
		 ListNode slow = head;
		 ListNode fast = head.next;
		 //快慢指针法找重点 不需要算出整个链表长度再找
		 while(fast != null && fast.next != null){
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 return slow;
	 }
	 private ListNode merge(ListNode head1, ListNode head2){
		 ListNode dummy = new ListNode(0);
		 ListNode tail = dummy;
		 while(head1 != null && head2 != null){
			 if(head1.val < head2.val){
				 tail.next = head1;
				 head1 = head1.next;
			 }else{
				 tail.next = head2;
				 head2 = head2.next;
			 }
			 tail = tail.next;
		 }
		 if(head1 != null){
			 tail.next = head1;
		 }else{
			 tail.next = head2;
		 }
		 return dummy.next;
	 }
}
