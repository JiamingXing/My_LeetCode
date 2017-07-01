package linkedList;
//程序看起来有些冗长而且running time较大 想想如何修改？
//变量取名最好用current 把 head 区分开来？
public class MergeSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while(l1 != null || l2 != null){
			if(l1 == null && l2 != null){
				prev.next = l2;
				prev = prev.next;
				l2 = l2.next;
			}else if(l1 != null && l2 ==null){
				prev.next = l1;
				prev = prev.next;
				l1 = l1.next;
			}else{
				if(l1.val <= l2.val){
					prev.next = l1;
					prev = prev.next;
					l1 = l1.next;
				}else{
					prev.next = l2;
					prev = prev.next;
					l2 = l2.next;
				}
			}
		}
		return dummy.next;
	}
}

//体会一下递归写法 好像时间更慢。。？
/*
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
*/
