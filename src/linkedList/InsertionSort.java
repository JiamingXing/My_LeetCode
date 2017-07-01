package linkedList;
//发现一个规律 linked list里面多加几个指针好像都没什么问题。。
//需要区分节点的时候就加指针
//这里new了n个节点所以是O(n) space 同理感觉多加几个指针就可以in place操作
public class InsertionSort {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = new ListNode(head.val);
		head = head.next;
		ListNode prev = dummy;
		ListNode current = dummy.next;
		ListNode tail = dummy.next;
		tail.next = null;
		while(head != null){
			while(current != null && head.val > current.val){
				prev = current;
				current = current.next;
			}
			if(current == null){
				prev.next = new ListNode(head.val);
				tail = prev.next;
			}else{
				prev.next = new ListNode(head.val);
				prev.next.next = current;
			}
			prev = dummy;
			head = head.next;
			current = dummy.next;
		}
		tail.next = null;
		return dummy.next;
	}
}


//看看别人的做法 O(1) space?
//但是好像时间比我这个还要慢？
/*
public ListNode insertionSortList(ListNode head) {
	if( head == null ){
		return head;
	}
	
	ListNode helper = new ListNode(0); //new starter of the sorted list
	ListNode cur = head; //the node will be inserted
	ListNode pre = helper; //insert node between pre and pre.next
	ListNode next = null; //the next node will be inserted
	//not the end of input list
	while( cur != null ){
		next = cur.next;
		//find the right place to insert
		while( pre.next != null && pre.next.val < cur.val ){
			pre = pre.next;
		}
		//insert between pre and pre.next
		cur.next = pre.next;
		pre.next = cur;
		pre = helper;
		cur = next;
	}
	
	return helper.next;
}
*/


//自己写的不new nodes 但是没有通过 想想问什么
//time limit exceed
/*
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = prev.next;
        head = head.next;
        while(head != null){
            while(current != null && current.val <= head.val){
                if(current != head){
                    prev = prev.next;
                    current = current.next;
                }else{
                    break;
                }
            }
            ListNode temp = head.next;
            if(current != head){
                prev.next = head;
                head.next = current;
            }
            prev = dummy;
            current = prev.next;
            head = temp;
        }
        return dummy.next;
    }
}
*/
