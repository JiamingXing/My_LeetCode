package linkedList;
//做list的题先画图很重要
//自己做的错误的思路 我先找到新的head
//但是对于[1,2] k = 3的case我不需要reverse会出问题 但是题目条件是k小于等于list的长度的
//如果这个条件成立我这么写是OK的
public class ReverseNodesKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 0 || k == 1){
			return head;
		}
		ListNode dummy = new ListNode(0);
		int num = k;
        ListNode newHead = head;
        while (num > 0) {
            newHead = newHead.next;
            num --;
        }
        dummy.next = newHead;
        while (head != null) {
            int n = k;
            ListNode tail = head;
            //先找prev
            while (n > 0) {
                if (tail == null) {
                    tail = head;
                    break;
                }
                tail = tail.next;
                n --;
            }
            if (tail == head) {
                break;
            } else {
                ListNode prev = tail;
                while (head != tail) {
                    ListNode temp = head.next;
                    head.next = prev;
                    prev = head;
                    head = temp;    
                }
            }
        }
        return dummy.next;
	}
}

/*
//用递归写的正确的版本
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 || k == 1){
			return head;
		}
		ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count ++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count --;
            }
            head = cur;
        }
        return head;
    }
}
*/
