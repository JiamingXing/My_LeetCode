package review;
//之前的perfect BT没到一个点我都设置当前点的next指向谁
//这道题是每到一个点，我都设置它之前那个点指向当前这个点，并把它更新成prev，可以给下一个点使用
public class PopulatingNextRightPointerII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = root;
		TreeLinkNode cur = null;
		TreeLinkNode prev = null;
		while (head != null) {
			cur = head;
			//每一层循环的开始都必须把head和prev先变成null
			//加入最后一层，没有任何的孩子了 那head是不做任何改变的 循环应该停止
			//所以如果head不在一开始变成null 会出现无限循环的情况
			prev = null;
			head = null;
			while (cur != null) {
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				cur = cur.next;
			}
		}
	}
}
