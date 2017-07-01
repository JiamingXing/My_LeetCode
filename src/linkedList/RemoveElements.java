package linkedList;
//遍历一遍linked list 移除指定元素
/*
public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
		//首先head也可能是要移除的node所以我们要先加一个dummy node
		if(head == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while(head != null && head.next != null){
			ListNode temp = head.next.next;
			if(head.next.val == val){
				head.next = temp;
				head = head.next;
			}else{
				head = head.next;
			}	
		}
		return dummy.next;
	}
}
*/
//一部分case没有通过 [1,1] -> [1]
//想想为什么没考虑到这个错误？？？？？？怎么修改
public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
		//首先head也可能是要移除的node所以我们要先加一个dummy node
		if(head == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		//增加一个prev指针很重要 不改变dummy的位置但是同时移动💰一个指针
		ListNode prev = dummy;
		while(head != null ){
			
			if(head.val == val){
				prev.next = head.next;
				head = head.next;
			}else{
				prev = prev.next;
				head = head.next;
			}	
		}
		return dummy.next;
	}
}


/*
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
}
*/

