package linkedList;
//from end
//核心思路利用快慢指针
public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode prev = dummy;
		for(int i = 1; i <= n; i ++){
			slow = slow.next;
		}
		ListNode fast = slow;
		slow = dummy;
		//先跳一步多让一个prev出来操作 如何改进？
		slow = slow.next;
		fast = fast.next;
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
			prev = prev.next;
		}
		ListNode temp = slow.next;
		prev.next = temp;
		return dummy.next;
	}
}

//别人写的体现思路比我写的清晰很多 要学习一下

/*
public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}
*/
