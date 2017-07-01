package linkedList;
//通过两个reverse的题搞清楚为什么需要一个temp 
//这道题最关键的是 两个if判断语句 如果空的话直接返回空
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(m >= n || head == null){
			return head;
		}
		//分析题目如果head可能会发生改变就加个dummy node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		for(int i = 1; i < m; i++){
			if(head.next != null){
				head = head.next;
			}
			//if(head == null){
			//	return null;
		    //}
		}
		//我需要4个指针！
		ListNode prevM = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode;
		ListNode postN = mNode.next;
		for(int i = m; i < n; i++){
			if(postN == null){
				return null;
			}
			ListNode temp = postN.next;
			postN.next = nNode;
			nNode = postN;
			postN = temp;
		}
		mNode.next = postN;
		prevM.next = nNode;
		return dummy.next;
	}
}



