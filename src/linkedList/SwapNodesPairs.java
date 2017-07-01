package linkedList;
//这道题自己写出来的递归！ 再体会一下当时思考的思路！
public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		return swap(head, head.next);
		
	}
	private ListNode swap(ListNode A, ListNode B){
		ListNode temp = B.next;
		B.next = A;
		if(temp == null){
			A.next = temp;
		}else if(temp.next == null){
			A.next = temp;
		}else{
			A.next = swap(temp, temp.next);
		}
		return B;
	}
}
