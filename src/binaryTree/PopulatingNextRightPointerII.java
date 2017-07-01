package binaryTree;

//这道题不能用queue 应为要求constant space
/*
public class PopulatingNextRightPointerII {
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> q = new LinkedList<>();
		q.offer(root);
		//add dummy node null
		q.offer(null);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				if (q.peek() == null) {
					q.poll();
					continue;
				} else {
					if (q.peek().left != null) {
						q.offer(q.peek().left);
					}
					if (q.peek().right != null) {
						q.offer(q.peek().right);
					}
					q.poll().next = q.peek();
				}
			}
			//add dummy node null between different levels
			if (!q.isEmpty()) {
				q.offer(null);
			}
		}
	}
}
*/
//别人的做法：
//比较巧妙的思路
public class PopulatingNextRightPointerII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head=root;//The left most node in the lower level
        TreeLinkNode prev=null;//The previous node in the lower level
        TreeLinkNode curr=null;//The current node in the upper level
        while (head!=null){
            curr=head;
            prev=null;
            head=null;
            while (curr!=null){
                if (curr.left!=null){
                    if (prev!=null)
                        prev.next=curr.left;
                    else 
                        head=curr.left;
                    prev=curr.left;
                }
                if (curr.right!=null){
                    if (prev!=null)
                        prev.next=curr.right;
                    else 
                        head=curr.right;
                    prev=curr.right;
                }
                curr=curr.next;
            }
        }
	}
}


