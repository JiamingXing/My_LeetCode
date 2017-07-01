package linkedList;
//程序是对的但是写的很冗长。。
//想想有没有多余的指针 可以简化？
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummyOdd = new ListNode(0);
		ListNode dummyEven = new ListNode(0);
		ListNode headOdd = head;
		ListNode headEven = head.next;
		dummyOdd.next = headOdd;
		dummyEven.next = headEven;
		while(headOdd != null || headEven != null){
			if(headEven.next == null){
				break;
			}else if(headEven.next.next == null){
				headOdd.next = headEven.next;
				headOdd = headOdd.next;
				break;
			}else{
				headOdd.next = headEven.next;
				headEven.next = headEven.next.next;
				headOdd = headOdd.next;
				headEven = headEven.next;
			}
		}
		headOdd.next = dummyEven.next;
		headEven.next = null;
		return dummyOdd.next;
		
	}
}

//看看别人写的很简洁。。
/*
public class Solution {
public ListNode oddEvenList(ListNode head) {
    if (head != null) {
    
        ListNode odd = head, even = head.next, evenHead = even; 
    
        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}
}
*/
